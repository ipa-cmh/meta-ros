# Created by ipa-cmh
#
# Copyright 2020 Fraunhofer IPA

inherit ros_distro_melodic
inherit ros_component

DESCRIPTION = "ur_robot_driver"
AUTHOR = "Thomas Timm Andersen"
ROS_AUTHOR = "Simon Rasmussen"
HOMEPAGE = "http://wiki.ros.org/ur_robot_driver"
SECTION = "master"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=13;endline=13;md5=090c1f08fe66f634957237df6847a5b4fa9f9bc8"

ROS_CN = "ur_robot_driver"
ROS_BPN = "ur_robot_driver"

ROS_BUILD_DEPENDS = " \
    actionlib \
    control-msgs \
    controller-manager \
    geometry-msgs \
    hardware-interface \
    pluginlib \
    roscpp \
    sensor-msgs \
    tf \
    tf2-msgs \
    tf2-geometry-msgs \
    trajectory-msgs \
    ur-controllers \
    ur-dashboard-msgs \
    ur-msgs \
    std-srvs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    actionlib \
    control-msgs \
    controller-manager \
    geometry-msgs \
    hardware-interface \
    pluginlib \
    roscpp \
    sensor-msgs \
    tf \
    tf2-msgs \
    tf2-geometry-msgs \
    trajectory-msgs \
    ur-controllers \
    ur-dashboard-msgs \
    ur-msgs \
    std-srvs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    actionlib \
    control-msgs \
    controller-manager \
    geometry-msgs \
    hardware-interface \
    pluginlib \
    roscpp \
    sensor-msgs \
    tf \
    tf2-msgs \
    tf2-geometry-msgs \
    trajectory-msgs \
    ur-controllers \
    ur-dashboard-msgs \
    ur-msgs \
    std-srvs \
    force-torque-sensor-controller  \
    joint-state-controller  \
    joint-trajectory-controller  \
    robot-state-publisher  \
    socat  \
    ur-description  \
    velocity-controllers  \
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
SRC_URI = "git://github.com/ipa-cmh/Universal_Robots_ROS_Driver;branch=ur_robot_driver;protocol=https"
SRCREV = "090c1f08fe66f634957237df6847a5b4fa9f9bc8"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
