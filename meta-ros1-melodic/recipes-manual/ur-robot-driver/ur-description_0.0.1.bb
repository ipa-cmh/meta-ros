# Created by ipa-cmh
#
# Copyright 2020 Fraunhofer IPA

inherit ros_distro_melodic
inherit ros_component

DESCRIPTION = "ur_description"
AUTHOR = "Wim Meeussen"
ROS_AUTHOR = "Wim Meeussen"
HOMEPAGE = "http://ros.org/wiki/ur_description"
SECTION = "master"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=17;endline=17;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "ur_robot_driver"
ROS_BPN = "ur_description"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    joint-state-publisher \
    robot-state-publisher \
    rviz \
    urdf \
    xacro \
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
SRC_URI = "git://github.com/ipa-cmh/universal_robot;branch=ur_description;protocol=https"
SRCREV = "ba67d604afb866514c5d06046dc8df3d5e8a10fc"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
