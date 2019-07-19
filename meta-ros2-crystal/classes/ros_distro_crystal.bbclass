# Every ROS recipe, generated or not, must contain "inherit ros_distro_${ROS_DISTRO}".
#
# Copyright (c) 2019 LG Electronics, Inc.

ROS_DISTRO = "crystal"

require conf/ros-distro/include/${ROS_DISTRO}/generated/superflore-ros-distro.inc
require conf/ros-distro/include/${ROS_DISTRO}/ros-distro.inc

inherit ${ROS_DISTRO_TYPE}_distro
