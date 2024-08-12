package com.superherczeg.glassy.portal;

public class PortalInfo {
    public PortalCarrier parent;

    public int orientation = 0;// 90 degree increments
    public int face = 0; //0 = face up, 1 = face down, 2 = horizontal
    public boolean horizontal = false;

    public double height = 3.0D; //height of scanzone
    public double width = 1.5D; //width of scanzone

    public double offsetHeight = 1.0D; //height offset of scanzone
    public double offsetDepth = 0.1D; //depth offset of scanzone

    public boolean active = true; //if inactive... don't render the projection or teleport at all

    public boolean project = false; //show projection, obviously.

    public String channelName = "Unnamed";

    public PortalInfo link;
}
