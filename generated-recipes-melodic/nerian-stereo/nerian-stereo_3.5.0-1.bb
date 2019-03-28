# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "Driver node for SceneScan and SP1 stereo vision sensors by Nerian Vision GmbH"
AUTHOR = "Konstantin Schauwecker <konstantin.schauwecker@nerian.com>"
ROS_AUTHOR = "Nerian Vision Technologies <service@nerian.com>"
HOMEPAGE = "http://wiki.ros.org/nerian_stereo"
SECTION = "devel"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=58e54c03ca7f821dd3967e2a2cd1596e"

ROS_CN = "nerian_stereo"
ROS_BPN = "nerian_stereo"

ROS_BUILD_DEPENDS = " \
    boost \
    cv-bridge \
    dynamic-reconfigure \
    message-generation \
    nodelet \
    roscpp \
    sensor-msgs \
    std-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    boost \
    curl \
    cv-bridge \
    dynamic-reconfigure \
    message-runtime \
    nodelet \
    roscpp \
    sensor-msgs \
    std-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    boost \
    curl \
    cv-bridge \
    dynamic-reconfigure \
    message-runtime \
    nodelet \
    roscpp \
    sensor-msgs \
    std-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/nerian-vision/nerian_stereo-release/archive/release/melodic/nerian_stereo/3.5.0-1.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "37975870d09011444c3acced6a6b6673"
SRC_URI[sha256sum] = "ac5b61df9209fb01ccb8b20afc7a339450f5cffdb2bbb88d478b3c1a9dfc9dc4"
S = "${WORKDIR}/nerian_stereo-release-release-melodic-nerian_stereo-3.5.0-1"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('nerian-stereo', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('nerian-stereo', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/nerian-stereo/nerian-stereo_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/nerian-stereo/nerian-stereo-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/nerian-stereo/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/nerian-stereo/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}