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
    control_msgs \
    controller_manager \
    geometry_msgs \
    hardware_interface \
    pluginlib \
    roscpp \
    sensor_msgs \
    tf \
    tf2_msgs \
    tf2_geometry_msgs \
    trajectory_msgs \
    ur_controllers \
    ur_dashboard_msgs \
    ur_msgs \
    std_srvs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    actionlib \
    control_msgs \
    controller_manager \
    geometry_msgs \
    hardware_interface \
    pluginlib \
    roscpp \
    sensor_msgs \
    tf \
    tf2_msgs \
    tf2_geometry_msgs \
    trajectory_msgs \
    ur_controllers \
    ur_dashboard_msgs \
    ur_msgs \
    std_srvs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    actionlib \
    control_msgs \
    controller_manager \
    geometry_msgs \
    hardware_interface \
    pluginlib \
    roscpp \
    sensor_msgs \
    tf \
    tf2_msgs \
    tf2_geometry_msgs \
    trajectory_msgs \
    ur_controllers \
    ur_dashboard_msgs \
    ur_msgs \
    std_srvs \
    force_torque_sensor_controller  \
    joint_state_controller  \
    joint_trajectory_controller  \
    robot_state_publisher  \
    socat  \
    ur_description  \
    velocity_controllers  \
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
SRC_URI = "git://github.com/ipa-cmh/Universal_Robots_ROS_Driver;branch=ur-robot-driver;protocol=https"
SRCREV = "090c1f08fe66f634957237df6847a5b4fa9f9bc8"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
