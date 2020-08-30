package com.lsk.testmod.handlers;

import com.lsk.testmod.utils.CollectionUtil;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.event.entity.ProjectileImpactEvent;
import net.minecraftforge.event.entity.ThrowableImpactEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Mod.EventBusSubscriber
public class ShootHandler {
//	@SubscribeEvent
//	public static void onProjectileImpact(ProjectileImpactEvent.Throwable event){
//		System.out.println(event.getThrowable().getDisplayName());
//	}
	//private static final int mineR = 2;
	/*
		1 1 1 1 1
	 	1 1 1 1 1
	 	1 1 0 1 1
	 	1 1 1 1 1
	 	1 1 1 1 1
	 */
	private static Date lastDoneTime = new Date();
	@SubscribeEvent
	public static void onProjectileImpact(ThrowableImpactEvent event){
		if((new Date().getTime() - lastDoneTime.getTime()) < 1000){
			return;
		}
		Entity entity = event.getEntity();
		String entityName = entity.getName();
		if (entityName.equals("Snowball")){
			Vec3d hitLocation = event.getRayTraceResult().hitVec;
			System.out.println(hitLocation);
			System.out.println(event.getRayTraceResult().sideHit);
			getBlocks(hitLocation,event.getRayTraceResult().sideHit);

		}
		lastDoneTime = new Date();
	}
	private static List<BlockPos> getBlocks(Vec3d centre, EnumFacing side){
		double d1 = centre.x;
		double d2 = centre.y;
		double d3 = centre.z;
		switch(side){
			case UP:
				List<BlockPos> row1 = doGetBlocks(d1+2,d2,d3,false);
				List<BlockPos> row2 = doGetBlocks(d1+1,d2,d3,false);
				List<BlockPos> row3 = doGetBlocks(d1,d2,d3,false);
				List<BlockPos> row4 = doGetBlocks(d1-1,d2,d3,false);
				List<BlockPos> row5 = doGetBlocks(d1-2,d2,d3,false);
				CollectionUtil.printCollection(row1);
				CollectionUtil.printCollection(row2);
				CollectionUtil.printCollection(row3);
				CollectionUtil.printCollection(row4);
				CollectionUtil.printCollection(row5);
				return null;
			case EAST:
			case WEST:
			case NORTH:
			case SOUTH:
				List<BlockPos> row6 = doGetBlocks(d1,d2,d3+2,true);
				List<BlockPos> row7 = doGetBlocks(d1,d2,d3+1,true);
				List<BlockPos> row8 = doGetBlocks(d1,d2,d3,true);
				List<BlockPos> row9 = doGetBlocks(d1,d2,d3-1,true);
				List<BlockPos> row10 = doGetBlocks(d1,d2,d3-2,true);
				CollectionUtil.printCollection(row6);
				CollectionUtil.printCollection(row7);
				CollectionUtil.printCollection(row8);
				CollectionUtil.printCollection(row9);
				CollectionUtil.printCollection(row10);
				return null;
			default:
				return null;
		}
	}
	private static List<BlockPos> doGetBlocks(double x,double y,double z,boolean flag){
		List<BlockPos> result = new ArrayList<>();
		if(flag){ // west east south north
			BlockPos pos1 = new BlockPos(x,y,z+2);
			BlockPos pos2 = new BlockPos(x,y,z+1);
			BlockPos pos3 = new BlockPos(x,y,z);
			BlockPos pos4 = new BlockPos(x,y,z-1);
			BlockPos pos5 = new BlockPos(x,y,z-2);
			result.add(pos1);
			result.add(pos2);
			result.add(pos3);
			result.add(pos4);
			result.add(pos5);
		}else{ // up
			BlockPos pos1 = new BlockPos(x+2,y,z);
			BlockPos pos2 = new BlockPos(x+1,y,z);
			BlockPos pos3 = new BlockPos(x,y,z);
			BlockPos pos4 = new BlockPos(x-1,y,z);
			BlockPos pos5 = new BlockPos(x-2,y,z);
			result.add(pos1);
			result.add(pos2);
			result.add(pos3);
			result.add(pos4);
			result.add(pos5);
		}
		return result;
	}
}
