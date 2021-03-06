/*
*** MADE BY MITHION'S .SCHEMATIC TO JAVA CONVERTING TOOL v1.6 ***
*/

package com.salvestrom.w2theJungle.worldGen.structures.jungleTown;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.salvestrom.w2theJungle.init.JungleBlocks;
import com.salvestrom.w2theJungle.worldGen.loot_tables.JungleLootTableRegistry;
import com.salvestrom.w2theJungle.worldGen.structures.blockPlacmentBridge;
import com.salvestrom.w2theJungle.worldGen.structures.fillWithBlocks;

public class jungleCityLibrarySouth extends WorldGenerator
{
	public blockPlacmentBridge bridge = new blockPlacmentBridge();
	
	public ResourceLocation fillchest = JungleLootTableRegistry.JUNGLE_CHESTS_TOWN_LIBRARY;
	
	protected Block[] GetValidSpawnBlocks() {
		return new Block[] {
			Blocks.DIRT,
			Blocks.GRASS,
			Blocks.STONE
		};
	}

	public boolean LocationIsValidSpawn(World world, int i, int j, int k)
	{
		int distanceToAir = 0;
		BlockPos pos = new BlockPos(i, j, k);
		Block checkID = world.getBlockState(pos).getBlock();

		if(checkID != Blocks.AIR)
		{
			distanceToAir++;
			checkID = world.getBlockState(pos.add(0, distanceToAir, 0)).getBlock();
		}

		if (distanceToAir > 5){
			return false;
		}
		j += distanceToAir-1; 
		pos = new BlockPos(i, j, k);

		Block blockID = world.getBlockState(pos).getBlock();
		Block blockIDAbove = world.getBlockState(pos.up()).getBlock();
		Block blockIDBelow = world.getBlockState(pos.down()).getBlock();
		for (Block x : GetValidSpawnBlocks()){
			if (blockIDAbove != Blocks.AIR)
			{
				return false;
			}
			if (blockID == x){
				return true;
			}else if (blockID == Blocks.SNOW && blockIDBelow == x){
				return true;
			}
		}
		return false;
	}

	public jungleCityLibrarySouth() { }
	//the building can be 180 turned by swapping out k+ for k-.
	// however n/s facing stairs will need reorientating!!!!!!!!!!!!!
	//the misplaces steps look cool.

	public boolean generate(World world, Random rand, int i, int j, int k) {
		//check that each corner is one of the valid spawn blocks
		if(!LocationIsValidSpawn(world, i, j, k) || !LocationIsValidSpawn(world, i + 12, j, k) || !LocationIsValidSpawn(world, i + 12, j, k - 8) || !LocationIsValidSpawn(world, i, j, k - 8))
		{
			return false;
		}
		//put the lower number first or you'll get an infinite loop trying to ++ from 0 to -8
		new fillWithBlocks().fillWithRotation(world, i, j, k, 0, 12, 0, 11, -8, 0, Blocks.AIR, "e");
		
		bridge.setBlock(world, i + 0, j + 0, k - 0, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 0, j + 0, k - 1, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 0, j + 0, k - 2, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 0, j + 0, k - 3, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 0, j + 0, k - 4, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 0, j + 0, k - 5, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 0, j + 0, k - 6, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 0, j + 0, k - 7, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 0, j + 0, k - 8, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 0, j + 1, k - 0, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 0, j + 1, k - 1, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 0, j + 1, k - 2, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 0, j + 1, k - 3, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 0, j + 1, k - 4, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 0, j + 1, k - 5, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 0, j + 1, k - 6, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 0, j + 1, k - 7, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 0, j + 1, k - 8, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 0, j + 2, k - 1, JungleBlocks.mossystairs); //TODO 	
		bridge.setBlock(world, i + 0, j + 2, k - 7, JungleBlocks.mossystairs);
		bridge.setBlock(world, i + 0, j + 5, k - 1, JungleBlocks.mossystairs, 4, 2);
		bridge.setBlock(world, i + 0, j + 5, k - 7, JungleBlocks.mossystairs, 4, 2);
		bridge.setBlock(world, i + 0, j + 6, k - 1, JungleBlocks.mossyStoneSteps);
		bridge.setBlock(world, i + 0, j + 6, k - 7, JungleBlocks.mossyStoneSteps);
		bridge.setBlock(world, i + 0, j + 8, k - 1, JungleBlocks.mossyStoneSteps, 4, 2);
		bridge.setBlock(world, i + 0, j + 8, k - 7, JungleBlocks.mossyStoneSteps, 4, 2);
		bridge.setBlock(world, i + 0, j + 9, k - 1, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 0, j + 9, k - 7, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 1, j + 0, k - 0, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 1, j + 0, k - 1, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 1, j + 0, k - 2, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 1, j + 0, k - 3, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 1, j + 0, k - 4, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 1, j + 0, k - 5, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 1, j + 0, k - 6, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 1, j + 0, k - 7, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 1, j + 0, k - 8, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 1, j + 1, k - 0, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 1, j + 1, k - 1, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 1, j + 1, k - 2, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 1, j + 1, k - 3, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 1, j + 1, k - 4, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 1, j + 1, k - 5, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 1, j + 1, k - 6, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 1, j + 1, k - 7, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 1, j + 1, k - 8, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 1, j + 2, k - 0, JungleBlocks.mossystairs, 3, 2);
		bridge.setBlock(world, i + 1, j + 2, k - 1, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 1, j + 2, k - 2, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 1, j + 2, k - 3, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 1, j + 2, k - 4, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 1, j + 2, k - 5, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 1, j + 2, k - 6, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 1, j + 2, k - 7, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 1, j + 2, k - 8, JungleBlocks.mossystairs, 2, 2);
		bridge.setBlock(world, i + 1, j + 3, k - 1, Blocks.LOG, 3, 2);
		bridge.setBlock(world, i + 1, j + 3, k - 2, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 1, j + 3, k - 3, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 1, j + 3, k - 4, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 1, j + 3, k - 5, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 1, j + 3, k - 6, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 1, j + 3, k - 7, Blocks.LOG, 3, 2);
		bridge.setBlock(world, i + 1, j + 4, k - 1, Blocks.LOG, 3, 2);
		bridge.setBlock(world, i + 1, j + 4, k - 2, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 1, j + 4, k - 3, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 1, j + 4, k - 4, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 1, j + 4, k - 5, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 1, j + 4, k - 6, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 1, j + 4, k - 7, Blocks.LOG, 3, 2);
		bridge.setBlock(world, i + 1, j + 5, k - 0, JungleBlocks.mossystairs, 7, 2);
		bridge.setBlock(world, i + 1, j + 5, k - 1, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 1, j + 5, k - 2, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 1, j + 5, k - 3, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 1, j + 5, k - 4, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 1, j + 5, k - 5, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 1, j + 5, k - 6, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 1, j + 5, k - 7, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 1, j + 5, k - 8, JungleBlocks.mossystairs, 6, 2);
		bridge.setBlock(world, i + 1, j + 6, k - 0, JungleBlocks.mossyStoneSteps, 3, 2);
		bridge.setBlock(world, i + 1, j + 6, k - 1, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 1, j + 6, k - 2, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 1, j + 6, k - 3, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 1, j + 6, k - 4, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 1, j + 6, k - 5, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 1, j + 6, k - 6, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 1, j + 6, k - 7, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 1, j + 6, k - 8, JungleBlocks.mossyStoneSteps, 2, 2);
		bridge.setBlock(world, i + 1, j + 7, k - 1, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 1, j + 7, k - 2, JungleBlocks.mossystairs, 4, 2);
		bridge.setBlock(world, i + 1, j + 7, k - 3, JungleBlocks.mossystairs, 4, 2);
		bridge.setBlock(world, i + 1, j + 7, k - 4, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 1, j + 7, k - 5, JungleBlocks.mossystairs, 4, 2);
		bridge.setBlock(world, i + 1, j + 7, k - 6, JungleBlocks.mossystairs, 4, 2);
		bridge.setBlock(world, i + 1, j + 7, k - 7, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 1, j + 8, k - 0, JungleBlocks.mossyStoneSteps, 6, 2);
		bridge.setBlock(world, i + 1, j + 8, k - 1, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 1, j + 8, k - 2, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 1, j + 8, k - 3, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 1, j + 8, k - 4, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 1, j + 8, k - 5, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 1, j + 8, k - 6, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 1, j + 8, k - 7, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 1, j + 8, k - 8, JungleBlocks.mossyStoneSteps, 7, 2);
		bridge.setBlock(world, i + 1, j + 9, k - 0, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 1, j + 9, k - 1, JungleBlocks.jungleBrazier);
		bridge.setBlock(world, i + 1, j + 9, k - 2, JungleBlocks.mossystairs, 2, 2);
		bridge.setBlock(world, i + 1, j + 9, k - 6, JungleBlocks.mossystairs, 3, 2);
		bridge.setBlock(world, i + 1, j + 9, k - 7, JungleBlocks.jungleBrazier);
		bridge.setBlock(world, i + 1, j + 9, k - 8, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 2, j + 0, k - 0, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 2, j + 0, k - 1, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 2, j + 0, k - 4, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 2, j + 0, k - 7, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 2, j + 0, k - 8, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 2, j + 1, k - 0, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 2, j + 1, k - 1, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 2, j + 1, k - 2, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 2, j + 1, k - 3, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 2, j + 1, k - 4, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 2, j + 1, k - 5, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 2, j + 1, k - 6, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 2, j + 1, k - 7, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 2, j + 1, k - 8, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 2, j + 2, k - 1, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 2, j + 2, k - 3, Blocks.LOG, 3, 2);
		bridge.setBlock(world, i + 2, j + 2, k - 4, Blocks.LOG, 3, 2);
		bridge.setBlock(world, i + 2, j + 2, k - 6, Blocks.LOG, 3, 2);
		bridge.setBlock(world, i + 2, j + 2, k - 7, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 2, j + 3, k - 1, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 2, j + 3, k - 3, Blocks.BOOKSHELF);
		bridge.setBlock(world, i + 2, j + 3, k - 4, Blocks.BOOKSHELF);
		bridge.setBlock(world, i + 2, j + 3, k - 6, Blocks.BOOKSHELF);
		bridge.setBlock(world, i + 2, j + 3, k - 7, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 2, j + 4, k - 1, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 2, j + 4, k - 3, Blocks.BOOKSHELF);
		bridge.setBlock(world, i + 2, j + 4, k - 4, Blocks.BOOKSHELF);
		bridge.setBlock(world, i + 2, j + 4, k - 6, Blocks.BOOKSHELF);
		bridge.setBlock(world, i + 2, j + 4, k - 7, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 2, j + 5, k - 1, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 2, j + 5, k - 3, Blocks.JUNGLE_STAIRS, 5, 2);
		bridge.setBlock(world, i + 2, j + 5, k - 4, Blocks.JUNGLE_STAIRS, 5, 2);
		bridge.setBlock(world, i + 2, j + 5, k - 6, Blocks.JUNGLE_STAIRS, 7, 2);
		bridge.setBlock(world, i + 2, j + 5, k - 7, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 2, j + 6, k - 1, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 2, j + 6, k - 4, Blocks.LOG, 7, 2);
		bridge.setBlock(world, i + 2, j + 6, k - 7, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 2, j + 7, k - 1, JungleBlocks.mossystairs, 7, 2);
		bridge.setBlock(world, i + 2, j + 7, k - 2, Blocks.DIRT);
		bridge.setBlock(world, i + 2, j + 7, k - 3, Blocks.DIRT);
		bridge.setBlock(world, i + 2, j + 7, k - 4, Blocks.DIRT);
		bridge.setBlock(world, i + 2, j + 7, k - 5, Blocks.DIRT);
		bridge.setBlock(world, i + 2, j + 7, k - 6, Blocks.DIRT);
		bridge.setBlock(world, i + 2, j + 7, k - 7, JungleBlocks.mossystairs, 6, 2);
		bridge.setBlock(world, i + 2, j + 8, k - 1, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 2, j + 8, k - 2, Blocks.GRASS);
		bridge.setBlock(world, i + 2, j + 8, k - 3, Blocks.GRASS);
		bridge.setBlock(world, i + 2, j + 8, k - 4, Blocks.GRASS);
		bridge.setBlock(world, i + 2, j + 8, k - 5, Blocks.GRASS);
		bridge.setBlock(world, i + 2, j + 8, k - 6, Blocks.GRASS);
		bridge.setBlock(world, i + 2, j + 8, k - 7, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 2, j + 9, k - 1, JungleBlocks.mossystairs, 1, 2);
		bridge.setBlock(world, i + 2, j + 9, k - 7, JungleBlocks.mossystairs, 1, 2);
		bridge.setBlock(world, i + 3, j + 0, k - 0, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 3, j + 0, k - 1, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 3, j + 0, k - 2, Blocks.AIR);
		bridge.setBlock(world, i + 3, j + 0, k - 3, Blocks.AIR);
		bridge.setBlock(world, i + 3, j + 0, k - 4, Blocks.AIR);
		bridge.setBlock(world, i + 3, j + 0, k - 5, Blocks.AIR);
		bridge.setBlock(world, i + 3, j + 0, k - 6, Blocks.AIR);
		bridge.setBlock(world, i + 3, j + 0, k - 7, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 3, j + 0, k - 8, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 3, j + 1, k - 0, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 3, j + 1, k - 1, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 3, j + 1, k - 2, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 3, j + 1, k - 3, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 3, j + 1, k - 4, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 3, j + 1, k - 5, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 3, j + 1, k - 6, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 3, j + 1, k - 7, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 3, j + 1, k - 8, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 3, j + 2, k - 1, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 3, j + 2, k - 6, Blocks.LOG, 3, 2);
		bridge.setBlock(world, i + 3, j + 2, k - 7, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 3, j + 3, k - 1, Blocks.JUNGLE_FENCE);
		bridge.setBlock(world, i + 3, j + 3, k - 6, Blocks.BOOKSHELF);
		bridge.setBlock(world, i + 3, j + 3, k - 7, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 3, j + 4, k - 1, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 3, j + 4, k - 6, Blocks.BOOKSHELF);
		bridge.setBlock(world, i + 3, j + 4, k - 7, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 3, j + 5, k - 1, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 3, j + 5, k - 6, Blocks.JUNGLE_STAIRS, 7, 2);
		bridge.setBlock(world, i + 3, j + 5, k - 7, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 3, j + 6, k - 1, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 3, j + 6, k - 4, Blocks.LOG, 7, 2);
		bridge.setBlock(world, i + 3, j + 6, k - 7, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 3, j + 7, k - 1, JungleBlocks.mossystairs, 7, 2);
		bridge.setBlock(world, i + 3, j + 7, k - 2, Blocks.DIRT);
		bridge.setBlock(world, i + 3, j + 7, k - 3, Blocks.DIRT);
		bridge.setBlock(world, i + 3, j + 7, k - 4, Blocks.DIRT);
		bridge.setBlock(world, i + 3, j + 7, k - 5, Blocks.DIRT);
		bridge.setBlock(world, i + 3, j + 7, k - 6, Blocks.DIRT);
		bridge.setBlock(world, i + 3, j + 7, k - 7, JungleBlocks.mossystairs, 6, 2);
		bridge.setBlock(world, i + 3, j + 8, k - 1, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 3, j + 8, k - 2, Blocks.GRASS);
		bridge.setBlock(world, i + 3, j + 8, k - 3, Blocks.GRASS);
		bridge.setBlock(world, i + 3, j + 8, k - 4, Blocks.GRASS);
		bridge.setBlock(world, i + 3, j + 8, k - 5, Blocks.GRASS);
		bridge.setBlock(world, i + 3, j + 8, k - 6, Blocks.GRASS);
		bridge.setBlock(world, i + 3, j + 8, k - 7, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 4, j + 0, k - 0, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 4, j + 0, k - 1, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 4, j + 0, k - 7, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 4, j + 0, k - 8, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 4, j + 1, k - 0, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 4, j + 1, k - 1, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 4, j + 1, k - 2, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 4, j + 1, k - 3, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 4, j + 1, k - 4, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 4, j + 1, k - 5, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 4, j + 1, k - 6, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 4, j + 1, k - 7, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 4, j + 1, k - 8, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 4, j + 2, k - 1, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 4, j + 2, k - 7, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 4, j + 2, k - 8, JungleBlocks.mossystairs, 2, 2);
		bridge.setBlock(world, i + 4, j + 3, k - 1, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 4, j + 3, k - 7, Blocks.LOG, 3, 2);
		bridge.setBlock(world, i + 4, j + 4, k - 1, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 4, j + 4, k - 7, Blocks.LOG, 3, 2);
		bridge.setBlock(world, i + 4, j + 5, k - 1, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 4, j + 5, k - 2, JungleBlocks.mossystairs, 6, 2);
		bridge.setBlock(world, i + 4, j + 5, k - 6, JungleBlocks.mossystairs, 7, 2);
		bridge.setBlock(world, i + 4, j + 5, k - 7, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 4, j + 6, k - 0, Blocks.LOG, 11, 2);
		bridge.setBlock(world, i + 4, j + 6, k - 1, Blocks.LOG, 11, 2);
		bridge.setBlock(world, i + 4, j + 6, k - 2, Blocks.LOG, 11, 2);
		bridge.setBlock(world, i + 4, j + 6, k - 3, Blocks.LOG, 11, 2);
		bridge.setBlock(world, i + 4, j + 6, k - 4, Blocks.LOG, 11, 2);
		bridge.setBlock(world, i + 4, j + 6, k - 5, Blocks.LOG, 11, 2);
		bridge.setBlock(world, i + 4, j + 6, k - 6, Blocks.LOG, 11, 2);
		bridge.setBlock(world, i + 4, j + 6, k - 7, Blocks.LOG, 11, 2);
		bridge.setBlock(world, i + 4, j + 6, k - 8, Blocks.LOG, 11, 2);
		bridge.setBlock(world, i + 4, j + 7, k - 1, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 4, j + 7, k - 2, Blocks.DIRT);
		bridge.setBlock(world, i + 4, j + 7, k - 3, Blocks.DIRT);
		bridge.setBlock(world, i + 4, j + 7, k - 4, Blocks.DIRT);
		bridge.setBlock(world, i + 4, j + 7, k - 5, Blocks.DIRT);
		bridge.setBlock(world, i + 4, j + 7, k - 6, Blocks.DIRT);
		bridge.setBlock(world, i + 4, j + 7, k - 7, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 4, j + 8, k - 1, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 4, j + 8, k - 2, Blocks.GRASS);
		bridge.setBlock(world, i + 4, j + 8, k - 3, Blocks.GRASS);
		bridge.setBlock(world, i + 4, j + 8, k - 4, Blocks.GRASS);
		bridge.setBlock(world, i + 4, j + 8, k - 5, Blocks.GRASS);
		bridge.setBlock(world, i + 4, j + 8, k - 6, Blocks.GRASS);
		bridge.setBlock(world, i + 4, j + 8, k - 7, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 5, j + 0, k - 0, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 5, j + 0, k - 1, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 5, j + 0, k - 4, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 5, j + 0, k - 7, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 5, j + 0, k - 8, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 5, j + 1, k - 0, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 5, j + 1, k - 1, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 5, j + 1, k - 2, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 5, j + 1, k - 3, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 5, j + 1, k - 4, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 5, j + 1, k - 5, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 5, j + 1, k - 6, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 5, j + 1, k - 7, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 5, j + 1, k - 8, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 5, j + 2, k - 0, JungleBlocks.mossystairs, 3, 2);
		bridge.setBlock(world, i + 5, j + 2, k - 1, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 5, j + 2, k - 6, Blocks.LOG, 3, 2);
		bridge.setBlock(world, i + 5, j + 2, k - 7, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 5, j + 3, k - 1, Blocks.LOG, 3, 2);
		bridge.setBlock(world, i + 5, j + 3, k - 6, Blocks.BOOKSHELF);
		bridge.setBlock(world, i + 5, j + 3, k - 7, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 5, j + 4, k - 1, Blocks.LOG, 3, 2);
		bridge.setBlock(world, i + 5, j + 4, k - 6, Blocks.BOOKSHELF);
		bridge.setBlock(world, i + 5, j + 4, k - 7, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 5, j + 5, k - 1, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 5, j + 5, k - 6, Blocks.JUNGLE_STAIRS, 7, 2);
		bridge.setBlock(world, i + 5, j + 5, k - 7, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 5, j + 6, k - 1, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 5, j + 6, k - 4, Blocks.LOG, 7, 2);
		bridge.setBlock(world, i + 5, j + 6, k - 7, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 5, j + 7, k - 1, JungleBlocks.mossystairs, 7, 2);
		bridge.setBlock(world, i + 5, j + 7, k - 2, Blocks.DIRT);
		bridge.setBlock(world, i + 5, j + 7, k - 3, Blocks.DIRT);
		bridge.setBlock(world, i + 5, j + 7, k - 4, Blocks.DIRT);
		bridge.setBlock(world, i + 5, j + 7, k - 5, Blocks.DIRT);
		bridge.setBlock(world, i + 5, j + 7, k - 6, Blocks.DIRT);
		bridge.setBlock(world, i + 5, j + 7, k - 7, JungleBlocks.mossystairs, 6, 2);
		bridge.setBlock(world, i + 5, j + 8, k - 1, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 5, j + 8, k - 2, Blocks.GRASS);
		bridge.setBlock(world, i + 5, j + 8, k - 3, Blocks.GRASS);
		bridge.setBlock(world, i + 5, j + 8, k - 4, Blocks.GRASS);
		bridge.setBlock(world, i + 5, j + 8, k - 5, Blocks.GRASS);
		bridge.setBlock(world, i + 5, j + 8, k - 6, Blocks.GRASS);
		bridge.setBlock(world, i + 5, j + 8, k - 7, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 6, j + 0, k - 0, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 6, j + 0, k - 1, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 6, j + 0, k - 7, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 6, j + 0, k - 8, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 6, j + 1, k - 0, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 6, j + 1, k - 1, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 6, j + 1, k - 2, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 6, j + 1, k - 3, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 6, j + 1, k - 4, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 6, j + 1, k - 5, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 6, j + 1, k - 6, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 6, j + 1, k - 7, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 6, j + 1, k - 8, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 6, j + 2, k - 6, Blocks.LOG, 3, 2);
		bridge.setBlock(world, i + 6, j + 2, k - 7, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 6, j + 3, k - 6, Blocks.BOOKSHELF);
		bridge.setBlock(world, i + 6, j + 3, k - 7, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 6, j + 4, k - 1, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 6, j + 4, k - 6, Blocks.BOOKSHELF);
		bridge.setBlock(world, i + 6, j + 4, k - 7, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 6, j + 5, k - 1, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 6, j + 5, k - 6, Blocks.JUNGLE_STAIRS, 7, 2);
		bridge.setBlock(world, i + 6, j + 5, k - 7, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 6, j + 6, k - 1, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 6, j + 6, k - 4, Blocks.LOG, 7, 2);
		bridge.setBlock(world, i + 6, j + 6, k - 7, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 6, j + 7, k - 1, JungleBlocks.mossystairs, 7, 2);
		bridge.setBlock(world, i + 6, j + 7, k - 2, Blocks.DIRT);
		bridge.setBlock(world, i + 6, j + 7, k - 3, Blocks.DIRT);
		bridge.setBlock(world, i + 6, j + 7, k - 4, Blocks.DIRT);
		bridge.setBlock(world, i + 6, j + 7, k - 5, Blocks.DIRT);
		bridge.setBlock(world, i + 6, j + 7, k - 6, Blocks.DIRT);
		bridge.setBlock(world, i + 6, j + 7, k - 7, JungleBlocks.mossystairs, 6, 2);
		bridge.setBlock(world, i + 6, j + 8, k - 1, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 6, j + 8, k - 2, Blocks.GRASS);
		bridge.setBlock(world, i + 6, j + 8, k - 3, Blocks.GRASS);
		bridge.setBlock(world, i + 6, j + 8, k - 4, Blocks.GRASS);
		bridge.setBlock(world, i + 6, j + 8, k - 5, Blocks.GRASS);
		bridge.setBlock(world, i + 6, j + 8, k - 6, Blocks.GRASS);
		bridge.setBlock(world, i + 6, j + 8, k - 7, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 7, j + 0, k - 0, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 7, j + 0, k - 1, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 7, j + 0, k - 7, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 7, j + 0, k - 8, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 7, j + 1, k - 0, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 7, j + 1, k - 1, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 7, j + 1, k - 2, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 7, j + 1, k - 3, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 7, j + 1, k - 4, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 7, j + 1, k - 5, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 7, j + 1, k - 6, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 7, j + 1, k - 7, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 7, j + 1, k - 8, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 7, j + 2, k - 0, JungleBlocks.mossystairs, 3, 2);
		bridge.setBlock(world, i + 7, j + 2, k - 1, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 7, j + 2, k - 6, Blocks.LOG, 3, 2);
		bridge.setBlock(world, i + 7, j + 2, k - 7, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 7, j + 3, k - 1, Blocks.LOG, 3, 2);
		bridge.setBlock(world, i + 7, j + 3, k - 6, Blocks.BOOKSHELF);
		bridge.setBlock(world, i + 7, j + 3, k - 7, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 7, j + 4, k - 1, Blocks.LOG, 3, 2);
		bridge.setBlock(world, i + 7, j + 4, k - 6, Blocks.BOOKSHELF);
		bridge.setBlock(world, i + 7, j + 4, k - 7, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 7, j + 5, k - 1, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 7, j + 5, k - 6, Blocks.JUNGLE_STAIRS, 7, 2);
		bridge.setBlock(world, i + 7, j + 5, k - 7, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 7, j + 6, k - 1, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 7, j + 6, k - 4, Blocks.LOG, 7, 2);
		bridge.setBlock(world, i + 7, j + 6, k - 7, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 7, j + 7, k - 1, JungleBlocks.mossystairs, 7, 2);
		bridge.setBlock(world, i + 7, j + 7, k - 2, Blocks.DIRT);
		bridge.setBlock(world, i + 7, j + 7, k - 3, Blocks.DIRT);
		bridge.setBlock(world, i + 7, j + 7, k - 4, Blocks.DIRT);
		bridge.setBlock(world, i + 7, j + 7, k - 5, Blocks.DIRT);
		bridge.setBlock(world, i + 7, j + 7, k - 6, Blocks.DIRT);
		bridge.setBlock(world, i + 7, j + 7, k - 7, JungleBlocks.mossystairs, 6, 2);
		bridge.setBlock(world, i + 7, j + 8, k - 1, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 7, j + 8, k - 2, Blocks.GRASS);
		bridge.setBlock(world, i + 7, j + 8, k - 3, Blocks.GRASS);
		bridge.setBlock(world, i + 7, j + 8, k - 4, Blocks.GRASS);
		bridge.setBlock(world, i + 7, j + 8, k - 5, Blocks.GRASS);
		bridge.setBlock(world, i + 7, j + 8, k - 6, Blocks.GRASS);
		bridge.setBlock(world, i + 7, j + 8, k - 7, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 8, j + 0, k - 0, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 8, j + 0, k - 1, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 8, j + 0, k - 4, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 8, j + 0, k - 7, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 8, j + 0, k - 8, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 8, j + 1, k - 0, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 8, j + 1, k - 1, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 8, j + 1, k - 2, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 8, j + 1, k - 3, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 8, j + 1, k - 4, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 8, j + 1, k - 5, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 8, j + 1, k - 6, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 8, j + 1, k - 7, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 8, j + 1, k - 8, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 8, j + 2, k - 1, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 8, j + 2, k - 6, Blocks.CRAFTING_TABLE);
		bridge.setBlock(world, i + 8, j + 2, k - 7, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 8, j + 2, k - 8, JungleBlocks.mossystairs, 2, 2);
		bridge.setBlock(world, i + 8, j + 3, k - 1, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 8, j + 3, k - 7, Blocks.LOG, 3, 2);
		bridge.setBlock(world, i + 8, j + 4, k - 1, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 8, j + 4, k - 7, Blocks.LOG, 3, 2);
		bridge.setBlock(world, i + 8, j + 5, k - 1, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 8, j + 5, k - 2, JungleBlocks.mossystairs, 6, 2);
		bridge.setBlock(world, i + 8, j + 5, k - 6, JungleBlocks.mossystairs, 7, 2);
		bridge.setBlock(world, i + 8, j + 5, k - 7, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 8, j + 6, k - 0, Blocks.LOG, 11, 2);
		bridge.setBlock(world, i + 8, j + 6, k - 1, Blocks.LOG, 11, 2);
		bridge.setBlock(world, i + 8, j + 6, k - 2, Blocks.LOG, 11, 2);
		bridge.setBlock(world, i + 8, j + 6, k - 3, Blocks.LOG, 11, 2);
		bridge.setBlock(world, i + 8, j + 6, k - 4, Blocks.LOG, 11, 2);
		bridge.setBlock(world, i + 8, j + 6, k - 5, Blocks.LOG, 11, 2);
		bridge.setBlock(world, i + 8, j + 6, k - 6, Blocks.LOG, 11, 2);
		bridge.setBlock(world, i + 8, j + 6, k - 7, Blocks.LOG, 11, 2);
		bridge.setBlock(world, i + 8, j + 6, k - 8, Blocks.LOG, 11, 2);
		bridge.setBlock(world, i + 8, j + 7, k - 1, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 8, j + 7, k - 2, Blocks.DIRT);
		bridge.setBlock(world, i + 8, j + 7, k - 3, Blocks.DIRT);
		bridge.setBlock(world, i + 8, j + 7, k - 4, Blocks.DIRT);
		bridge.setBlock(world, i + 8, j + 7, k - 5, Blocks.DIRT);
		bridge.setBlock(world, i + 8, j + 7, k - 6, Blocks.DIRT);
		bridge.setBlock(world, i + 8, j + 7, k - 7, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 8, j + 8, k - 1, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 8, j + 8, k - 2, Blocks.GRASS);
		bridge.setBlock(world, i + 8, j + 8, k - 3, Blocks.GRASS);
		bridge.setBlock(world, i + 8, j + 8, k - 4, Blocks.GRASS);
		bridge.setBlock(world, i + 8, j + 8, k - 5, Blocks.GRASS);
		bridge.setBlock(world, i + 8, j + 8, k - 6, Blocks.GRASS);
		bridge.setBlock(world, i + 8, j + 8, k - 7, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 9, j + 0, k - 0, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 9, j + 0, k - 1, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 9, j + 0, k - 7, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 9, j + 0, k - 8, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 9, j + 1, k - 0, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 9, j + 1, k - 1, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 9, j + 1, k - 2, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 9, j + 1, k - 3, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 9, j + 1, k - 4, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 9, j + 1, k - 5, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 9, j + 1, k - 6, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 9, j + 1, k - 7, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 9, j + 1, k - 8, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 9, j + 2, k - 1, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 9, j + 2, k - 6, Blocks.LOG, 3, 2);
		bridge.setBlock(world, i + 9, j + 2, k - 7, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 9, j + 3, k - 1, Blocks.JUNGLE_FENCE);
		bridge.setBlock(world, i + 9, j + 3, k - 6, Blocks.BOOKSHELF);
		bridge.setBlock(world, i + 9, j + 3, k - 7, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 9, j + 4, k - 1, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 9, j + 4, k - 6, Blocks.BOOKSHELF);
		bridge.setBlock(world, i + 9, j + 4, k - 7, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 9, j + 5, k - 1, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 9, j + 5, k - 6, Blocks.JUNGLE_STAIRS, 7, 2);
		bridge.setBlock(world, i + 9, j + 5, k - 7, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 9, j + 6, k - 1, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 9, j + 6, k - 4, Blocks.LOG, 7, 2);
		bridge.setBlock(world, i + 9, j + 6, k - 7, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 9, j + 7, k - 1, JungleBlocks.mossystairs, 7, 2);
		bridge.setBlock(world, i + 9, j + 7, k - 2, Blocks.DIRT);
		bridge.setBlock(world, i + 9, j + 7, k - 3, Blocks.DIRT);
		bridge.setBlock(world, i + 9, j + 7, k - 4, Blocks.DIRT);
		bridge.setBlock(world, i + 9, j + 7, k - 5, Blocks.DIRT);
		bridge.setBlock(world, i + 9, j + 7, k - 6, Blocks.DIRT);
		bridge.setBlock(world, i + 9, j + 7, k - 7, JungleBlocks.mossystairs, 6, 2);
		bridge.setBlock(world, i + 9, j + 8, k - 1, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 9, j + 8, k - 2, Blocks.GRASS);
		bridge.setBlock(world, i + 9, j + 8, k - 3, Blocks.GRASS);
		bridge.setBlock(world, i + 9, j + 8, k - 4, Blocks.GRASS);
		bridge.setBlock(world, i + 9, j + 8, k - 5, Blocks.GRASS);
		bridge.setBlock(world, i + 9, j + 8, k - 6, Blocks.GRASS);
		bridge.setBlock(world, i + 9, j + 8, k - 7, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 10, j + 0, k - 0, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 10, j + 0, k - 1, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 10, j + 0, k - 7, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 10, j + 0, k - 8, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 10, j + 1, k - 0, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 10, j + 1, k - 1, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 10, j + 1, k - 2, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 10, j + 1, k - 3, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 10, j + 1, k - 4, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 10, j + 1, k - 5, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 10, j + 1, k - 6, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 10, j + 1, k - 7, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 10, j + 1, k - 8, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 10, j + 2, k - 1, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 10, j + 2, k - 3, Blocks.LOG, 3, 2);
		bridge.setBlock(world, i + 10, j + 2, k - 4, Blocks.LOG, 3, 2);
		bridge.setBlock(world, i + 10, j + 2, k - 6, Blocks.LOG, 3, 2);
		bridge.setBlock(world, i + 10, j + 2, k - 7, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 10, j + 3, k - 1, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 10, j + 3, k - 3, Blocks.BOOKSHELF);
		bridge.setBlock(world, i + 10, j + 3, k - 4, Blocks.BOOKSHELF);
		bridge.setBlock(world, i + 10, j + 3, k - 6, Blocks.BOOKSHELF);
		bridge.setBlock(world, i + 10, j + 3, k - 7, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 10, j + 4, k - 1, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 10, j + 4, k - 3, Blocks.BOOKSHELF);
		bridge.setBlock(world, i + 10, j + 4, k - 4, Blocks.BOOKSHELF);
		bridge.setBlock(world, i + 10, j + 4, k - 6, Blocks.BOOKSHELF);
		bridge.setBlock(world, i + 10, j + 4, k - 7, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 10, j + 5, k - 1, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 10, j + 5, k - 3, Blocks.JUNGLE_STAIRS, 4, 2);
		bridge.setBlock(world, i + 10, j + 5, k - 4, Blocks.JUNGLE_STAIRS, 4, 2);
		bridge.setBlock(world, i + 10, j + 5, k - 6, Blocks.JUNGLE_STAIRS, 7, 2);
		bridge.setBlock(world, i + 10, j + 5, k - 7, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 10, j + 6, k - 1, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 10, j + 6, k - 4, Blocks.LOG, 7, 2);
		bridge.setBlock(world, i + 10, j + 6, k - 7, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 10, j + 7, k - 1, JungleBlocks.mossystairs, 7, 2);
		bridge.setBlock(world, i + 10, j + 7, k - 2, Blocks.DIRT);
		bridge.setBlock(world, i + 10, j + 7, k - 3, Blocks.DIRT);
		bridge.setBlock(world, i + 10, j + 7, k - 4, Blocks.DIRT);
		bridge.setBlock(world, i + 10, j + 7, k - 5, Blocks.DIRT);
		bridge.setBlock(world, i + 10, j + 7, k - 6, Blocks.DIRT);
		bridge.setBlock(world, i + 10, j + 7, k - 7, JungleBlocks.mossystairs, 6, 2);
		bridge.setBlock(world, i + 10, j + 8, k - 1, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 10, j + 8, k - 2, Blocks.GRASS);
		bridge.setBlock(world, i + 10, j + 8, k - 3, Blocks.GRASS);
		bridge.setBlock(world, i + 10, j + 8, k - 4, Blocks.GRASS);
		bridge.setBlock(world, i + 10, j + 8, k - 5, Blocks.GRASS);
		bridge.setBlock(world, i + 10, j + 8, k - 6, Blocks.GRASS);
		bridge.setBlock(world, i + 10, j + 8, k - 7, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 10, j + 9, k - 1, JungleBlocks.mossystairs);
		bridge.setBlock(world, i + 10, j + 9, k - 7, JungleBlocks.mossystairs);

		bridge.setBlock(world, i + 11, j + 0, k - 0, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 11, j + 0, k - 1, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 11, j + 0, k - 2, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 11, j + 0, k - 3, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 11, j + 0, k - 4, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 11, j + 0, k - 5, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 11, j + 0, k - 6, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 11, j + 0, k - 7, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 11, j + 0, k - 8, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 11, j + 1, k - 0, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 11, j + 1, k - 1, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 11, j + 1, k - 2, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 11, j + 1, k - 3, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 11, j + 1, k - 4, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 11, j + 1, k - 5, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 11, j + 1, k - 6, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 11, j + 1, k - 7, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 11, j + 1, k - 8, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 11, j + 2, k - 0, JungleBlocks.mossystairs, 3, 2);
		bridge.setBlock(world, i + 11, j + 2, k - 1, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 11, j + 2, k - 2, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 11, j + 2, k - 3, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 11, j + 2, k - 4, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 11, j + 2, k - 5, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 11, j + 2, k - 6, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 11, j + 2, k - 7, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 11, j + 2, k - 8, JungleBlocks.mossystairs, 2, 2);
		bridge.setBlock(world, i + 11, j + 3, k - 1, Blocks.LOG, 3, 2);
		bridge.setBlock(world, i + 11, j + 3, k - 2, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 11, j + 3, k - 3, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 11, j + 3, k - 4, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 11, j + 3, k - 5, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 11, j + 3, k - 6, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 11, j + 3, k - 7, Blocks.LOG, 3, 2);
		bridge.setBlock(world, i + 11, j + 4, k - 1, Blocks.LOG, 3, 2);
		bridge.setBlock(world, i + 11, j + 4, k - 2, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 11, j + 4, k - 3, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 11, j + 4, k - 4, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 11, j + 4, k - 5, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 11, j + 4, k - 6, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 11, j + 4, k - 7, Blocks.LOG, 3, 2);
		bridge.setBlock(world, i + 11, j + 5, k - 0, JungleBlocks.mossystairs, 7, 2);
		bridge.setBlock(world, i + 11, j + 5, k - 1, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 11, j + 5, k - 2, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 11, j + 5, k - 3, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 11, j + 5, k - 4, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 11, j + 5, k - 5, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 11, j + 5, k - 6, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 11, j + 5, k - 7, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 11, j + 5, k - 8, JungleBlocks.mossystairs, 6, 2);
		bridge.setBlock(world, i + 11, j + 6, k - 0, JungleBlocks.mossyStoneSteps, 3, 2);
		bridge.setBlock(world, i + 11, j + 6, k - 1, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 11, j + 6, k - 2, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 11, j + 6, k - 3, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 11, j + 6, k - 4, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 11, j + 6, k - 5, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 11, j + 6, k - 6, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 11, j + 6, k - 7, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 11, j + 6, k - 8, JungleBlocks.mossyStoneSteps, 2, 2);
		bridge.setBlock(world, i + 11, j + 7, k - 1, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 11, j + 7, k - 2, JungleBlocks.mossystairs, 5, 2);
		bridge.setBlock(world, i + 11, j + 7, k - 3, JungleBlocks.mossystairs, 5, 2);
		bridge.setBlock(world, i + 11, j + 7, k - 4, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 11, j + 7, k - 5, JungleBlocks.mossystairs, 5, 2);
		bridge.setBlock(world, i + 11, j + 7, k - 6, JungleBlocks.mossystairs, 5, 2);
		bridge.setBlock(world, i + 11, j + 7, k - 7, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 11, j + 8, k - 0, JungleBlocks.mossyStoneSteps, 6, 2);
		bridge.setBlock(world, i + 11, j + 8, k - 1, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 11, j + 8, k - 2, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 11, j + 8, k - 3, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 11, j + 8, k - 4, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 11, j + 8, k - 5, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 11, j + 8, k - 6, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 11, j + 8, k - 7, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 11, j + 8, k - 8, JungleBlocks.mossyStoneSteps, 7, 2);
		bridge.setBlock(world, i + 11, j + 9, k - 0, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 11, j + 9, k - 1, JungleBlocks.jungleBrazier);
		bridge.setBlock(world, i + 11, j + 9, k - 2, JungleBlocks.mossystairs, 2, 2);
		bridge.setBlock(world, i + 11, j + 9, k - 6, JungleBlocks.mossystairs, 3, 2);
		bridge.setBlock(world, i + 11, j + 9, k - 7, JungleBlocks.jungleBrazier);
		bridge.setBlock(world, i + 11, j + 9, k - 8, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 12, j + 0, k - 0, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 12, j + 0, k - 1, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 12, j + 0, k - 2, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 12, j + 0, k - 3, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 12, j + 0, k - 4, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 12, j + 0, k - 5, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 12, j + 0, k - 6, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 12, j + 0, k - 7, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 12, j + 0, k - 8, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 12, j + 1, k - 0, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 12, j + 1, k - 1, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 12, j + 1, k - 2, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 12, j + 1, k - 3, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 12, j + 1, k - 4, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 12, j + 1, k - 5, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 12, j + 1, k - 6, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 12, j + 1, k - 7, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 12, j + 1, k - 8, Blocks.STONEBRICK, 1, 2);
		bridge.setBlock(world, i + 12, j + 2, k - 1, JungleBlocks.mossystairs, 1, 2);
		bridge.setBlock(world, i + 12, j + 2, k - 7, JungleBlocks.mossystairs, 1, 2);
		bridge.setBlock(world, i + 12, j + 5, k - 1, JungleBlocks.mossystairs, 5, 2);
		bridge.setBlock(world, i + 12, j + 5, k - 7, JungleBlocks.mossystairs, 5, 2);
		bridge.setBlock(world, i + 12, j + 6, k - 1, JungleBlocks.mossyStoneSteps, 1, 2);
		bridge.setBlock(world, i + 12, j + 6, k - 7, JungleBlocks.mossyStoneSteps, 1, 2);
		bridge.setBlock(world, i + 12, j + 8, k - 1, JungleBlocks.mossyStoneSteps, 5, 2);
		bridge.setBlock(world, i + 12, j + 8, k - 7, JungleBlocks.mossyStoneSteps, 5, 2);
		bridge.setBlock(world, i + 12, j + 9, k - 1, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 12, j + 9, k - 7, Blocks.MOSSY_COBBLESTONE);
		bridge.setBlock(world, i + 4, j + 3, k - 2, Blocks.TORCH, 0, 2);
		bridge.setBlock(world, i + 6, j + 2, k - 1, Blocks.JUNGLE_DOOR, 1, 2);
		bridge.setBlock(world, i + 6, j + 3, k - 1, Blocks.JUNGLE_DOOR, 8, 2);
		bridge.setBlock(world, i + 8, j + 3, k - 2, Blocks.TORCH, 0, 2);
		
		//if(rand.nextInt(2)==0) {

		BlockPos pos = new BlockPos(i, j, k);

		TileEntityChest tec;

		if(world.getBlockState(pos.add(4, 1, - 6)).getBlock() != Blocks.AIR)
		{
			bridge.setBlock(world, i + 4, j + 2, k - 6, Blocks.CHEST, 1, 2);
				
				tec = (TileEntityChest)world.getTileEntity(pos.add(4, 2, -6));

				if(tec != null) {
					tec.setLootTable(fillchest, rand.nextLong());
				}
			}
		//}


		return true;
	}
	
	@Override
	public boolean generate(World wrld, Random rnd, BlockPos pos) {

		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		
		return this.generate(wrld, rnd, x, y, z);
	}

}