# Generated by superflore -- DO NOT EDIT
#
# Copyright 2020 Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "ROS Package for controlling the AStuff PACMod with a Joystick"
AUTHOR = "AutonomouStuff Software Development Team <software@autonomoustuff.com>"
ROS_AUTHOR = "Joe Driscoll <jdriscoll@autonomoustuff.com>"
HOMEPAGE = "http://wiki.ros.org/pacmod_game_control"
SECTION = "devel"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://package.xml;beginline=6;endline=6;md5=58e54c03ca7f821dd3967e2a2cd1596e"

ROS_CN = "pacmod_game_control"
ROS_BPN = "pacmod_game_control"

ROS_BUILD_DEPENDS = " \
    joy \
    pacmod-msgs \
    roscpp \
    roslint \
    sensor-msgs \
    std-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    joy \
    pacmod-msgs \
    roscpp \
    sensor-msgs \
    std-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    joy \
    pacmod-msgs \
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

# matches with: https://github.com/astuff/pacmod_game_control-release/archive/release/melodic/pacmod_game_control/3.0.1-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/pacmod_game_control"
SRC_URI = "git://github.com/astuff/pacmod_game_control-release;${ROS_BRANCH};protocol=https"
SRCREV = "5aa0f42f7f95799a03bd795a1c4f9fdbeb2e6eda"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
