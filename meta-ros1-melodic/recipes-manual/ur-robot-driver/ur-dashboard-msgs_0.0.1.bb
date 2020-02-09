# Created by ipa-cmh
#
# Copyright 2020 Fraunhofer IPA

inherit ros_distro_melodic
inherit ros_component

DESCRIPTION = "ur_dashboard_msgs"
AUTHOR = "Felix Exner"
ROS_AUTHOR = "Felix Exner"
HOMEPAGE = "http://wiki.ros.org/ur_robot_driver"
SECTION = "master"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=16;endline=16;md5=3dce4ba60d7e51ec64f3c3dc18672dd3"

ROS_CN = "ur_robot_driver"
ROS_BPN = "ur_dashboard_msgs"

ROS_BUILD_DEPENDS = " \
    actionlib-msgs \
    message-generation \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
    ${PYTHON_PN}-pyyaml-native \
"

ROS_EXPORT_DEPENDS = " \
    actionlib-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = " \
    actionlib-msgs \
    message-runtime \
"

ROS_EXEC_DEPENDS = " \
    actionlib-msgs \
    message-runtime \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"


SRC_URI = "git://github.com/ipa-cmh/Universal_Robots_ROS_Driver;branch=ur_dashboard_msgs;protocol=https"
SRCREV = "a9dcee067a80d545eba13ffdc82b515cc9a6723d"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
