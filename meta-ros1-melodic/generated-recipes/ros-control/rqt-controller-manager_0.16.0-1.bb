# Generated by superflore -- DO NOT EDIT
#
# Copyright 2020 Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "Graphical frontend for interacting with the controller manager."
AUTHOR = "Bence Magyar <bence.magyar.robotics@gmail.com>"
ROS_AUTHOR = "Kelsey Hawkins <kphawkins@gatech.edu>"
HOMEPAGE = "http://ros.org/wiki/rqt_controller_manager"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "ros_control"
ROS_BPN = "rqt_controller_manager"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    controller-manager-msgs \
    rospy \
    rqt-gui \
    rqt-gui-py \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros-gbp/ros_control-release/archive/release/melodic/rqt_controller_manager/0.16.0-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/rqt_controller_manager"
SRC_URI = "git://github.com/ros-gbp/ros_control-release;${ROS_BRANCH};protocol=https"
SRCREV = "5dac3611a87c3ad5b52b3834b0942b125eecfe66"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
