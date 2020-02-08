# Generated by superflore -- DO NOT EDIT
#
# Copyright 2020 Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "These are regression tests for the osm_cartography and      route_network packages. They are packaged separately to avoid      unnecessary implementation dependencies."
AUTHOR = "Jack O'Quin <jack.oquin@gmail.com>"
ROS_AUTHOR = "Jack O'Quin"
HOMEPAGE = "http://ros.org/wiki/test_osm"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "open_street_map"
ROS_BPN = "test_osm"

ROS_BUILD_DEPENDS = " \
    geodesy \
    geographic-msgs \
    osm-cartography \
    route-network \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    geodesy \
    geographic-msgs \
    osm-cartography \
    route-network \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    geodesy \
    geographic-msgs \
    osm-cartography \
    route-network \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros-geographic-info/open_street_map-release/archive/release/melodic/test_osm/0.2.5-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/test_osm"
SRC_URI = "git://github.com/ros-geographic-info/open_street_map-release;${ROS_BRANCH};protocol=https"
SRCREV = "bbae67b8143c7e6867a5a5ff50db0bb82721d2d9"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
