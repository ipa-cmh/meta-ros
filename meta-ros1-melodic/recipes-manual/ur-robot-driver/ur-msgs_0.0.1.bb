# Created by ipa-cmh
#
# Copyright 2020 Fraunhofer IPA

inherit ros_distro_melodic
inherit ros_component

DESCRIPTION = "ur_rmsgs"
AUTHOR = "Andrew Glusiec"
ROS_AUTHOR = "Andrew Glusiec"
HOMEPAGE = "http://wiki.ros.org/ur_robot_driver"
SECTION = "master"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=13;endline=13;md5=2c00b8d2854109dbebef7818b4dae1e2"

ROS_CN = "ur_robot_driver"
ROS_BPN = "ur_msgs"

ROS_BUILD_DEPENDS = " \
    message-generation \
    std-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
    ${PYTHON_PN}-pyyaml-native \
"

ROS_EXPORT_DEPENDS = " \
    std-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    std-msgs \
    message-runtime \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros-industrial-release/abb-release/archive/release/melodic/abb_driver/1.3.1-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/abb_driver"
SRC_URI = "git://github.com/ipa-cmh/universal_robot;branch=ur_msgs;protocol=https"
SRCREV = "6da0585fa6ad5918bf0c4618e3f388ffb4d6ed40"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
