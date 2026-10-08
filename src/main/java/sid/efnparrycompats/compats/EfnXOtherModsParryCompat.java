package sid.efnparrycompats.compats;



import com.hm.efn.gameasset.animations.EFNSkillAnimations;
import net.corruptdog.cdm.gameasset.CorruptAnimations;
import net.corruptdog.cdm.world.CorruptWeaponCategories;
import net.corruptdog.cdm.world.item.CDAddonItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import yesman.epicfight.api.client.forgeevent.WeaponCategoryIconRegisterEvent;
import yesman.epicfight.compat.ICompatModule;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.skill.guard.GuardSkill;


import yesman.epicfight.api.forgeevent.SkillBuildEvent.ModRegistryWorker.SkillCreateEvent;
import yesman.epicfight.world.capabilities.item.CapabilityItem;

import java.util.List;


public class EfnXOtherModsParryCompat implements ICompatModule{




    public static void onEfnParrySkillCreation(SkillCreateEvent<GuardSkill.Builder> event){
        if(event.getRegistryName().equals(ResourceLocation.fromNamespaceAndPath("efn","efn_parry"))){
            GuardSkill.Builder builder = event.getSkillBuilder();


            builder.addGuardMotion(CorruptWeaponCategories.YAMATO, (item, player) -> CorruptAnimations.YAMATO_GUARD_HIT)
                    .addGuardMotion(CorruptWeaponCategories.KATANA, (item, player) -> Animations.UCHIGATANA_GUARD_HIT)
                    .addGuardMotion(CorruptWeaponCategories.GREAT_TACHI, (item, player) -> item.getStyle(player) == CapabilityItem.Styles.TWO_HAND ? CorruptAnimations.TACHI_GUARD_HIT : Animations.SWORD_DUAL_GUARD_HIT)
                    .addGuardMotion(CorruptWeaponCategories.S_SWORD, (item, player) -> item.getStyle(player) == CapabilityItem.Styles.ONE_HAND ? Animations.SWORD_GUARD_HIT : Animations.SWORD_DUAL_GUARD_HIT)
                    .addGuardMotion(CorruptWeaponCategories.S_SPEAR, (item, player) -> Animations.SPEAR_GUARD_HIT)
                    .addGuardMotion(CorruptWeaponCategories.S_TACHI, (item, player) -> CorruptAnimations.TACHI_GUARD_HIT)
                    .addGuardMotion(CorruptWeaponCategories.S_GREATSWORD, (item, player) -> item.getStyle(player) == CapabilityItem.Styles.TWO_HAND ? Animations.GREATSWORD_GUARD_HIT : Animations.SWORD_DUAL_GUARD_HIT)
                    .addGuardMotion(CorruptWeaponCategories.S_LONGSWORD, (item, player) -> Animations.LONGSWORD_GUARD_HIT)
                    .addGuardMotion(CorruptWeaponCategories.PHANTOM_KATANA, (item, player) -> Animations.UCHIGATANA_GUARD_HIT)

                    .addGuardBreakMotion(CorruptWeaponCategories.YAMATO, (item, player) -> CorruptAnimations.GUARD_BREAK1)
                    .addGuardBreakMotion(CorruptWeaponCategories.KATANA, (item, player) -> CorruptAnimations.GUARD_BREAK1)
                    .addGuardBreakMotion(CorruptWeaponCategories.GREAT_TACHI, (item, player) -> CorruptAnimations.GUARD_BREAK2).addGuardBreakMotion(CorruptWeaponCategories.S_SWORD, (item, player) -> CorruptAnimations.GUARD_BREAK1)
                    .addGuardBreakMotion(CorruptWeaponCategories.S_SPEAR, (item, player) -> CorruptAnimations.GUARD_BREAK2).addGuardBreakMotion(CorruptWeaponCategories.S_TACHI, (item, player) -> CorruptAnimations.GUARD_BREAK2)
                    .addGuardBreakMotion(CorruptWeaponCategories.S_GREATSWORD, (item, player) -> CorruptAnimations.GUARD_BREAK2).addGuardBreakMotion(CorruptWeaponCategories.S_LONGSWORD, (item, player) -> CorruptAnimations.GUARD_BREAK2)
                    .addGuardBreakMotion(CorruptWeaponCategories.PHANTOM_KATANA, (item, player) -> CorruptAnimations.GUARD_BREAK1)



            .addAdvancedGuardMotion(CorruptWeaponCategories.KATANA, (capabilityItem, playerPatch) ->
                            List.of(EFNSkillAnimations.EFN_GUARD_ACTIVE_HIT1, EFNSkillAnimations.EFN_GUARD_ACTIVE_HIT2, CorruptAnimations.PARRY_BREAK4))
                    .addAdvancedGuardMotion(CorruptWeaponCategories.PHANTOM_KATANA, (capabilityItem, pp) ->
                            List.of(EFNSkillAnimations.EFN_GUARD_ACTIVE_HIT1, EFNSkillAnimations.EFN_GUARD_ACTIVE_HIT2, CorruptAnimations.PARRY_BREAK2))
                    .addAdvancedGuardMotion(CorruptWeaponCategories.S_LONGSWORD, (capabilityItem, pp) ->
                            List.of(EFNSkillAnimations.EFN_GUARD_ACTIVE_HIT1, EFNSkillAnimations.EFN_GUARD_ACTIVE_HIT2, CorruptAnimations.PARRY_BREAK3))
                    .addAdvancedGuardMotion(CorruptWeaponCategories.S_SPEAR,((capabilityItem, pp) ->
                            List.of(Animations.SWORD_GUARD_ACTIVE_HIT1,Animations.SWORD_GUARD_ACTIVE_HIT2,CorruptAnimations.PARRY_BREAK1)))
                    .addAdvancedGuardMotion(CorruptWeaponCategories.S_SWORD,((capabilityItem, pp) ->
                            List.of(EFNSkillAnimations.EFN_GUARD_ACTIVE_HIT1, EFNSkillAnimations.EFN_GUARD_ACTIVE_HIT2,EFNSkillAnimations.EFN_GUARD_ACTIVE_HIT3)))
                    .addAdvancedGuardMotion(CorruptWeaponCategories.S_TACHI,((capabilityItem, pp) ->
                            List.of(EFNSkillAnimations.EFN_GUARD_ACTIVE_HIT1, EFNSkillAnimations.EFN_GUARD_ACTIVE_HIT2,EFNSkillAnimations.EFN_GUARD_ACTIVE_HIT3)))
                    .addAdvancedGuardMotion(CorruptWeaponCategories.GREAT_TACHI,((capabilityItem, pp) ->
                            List.of(EFNSkillAnimations.EFN_GUARD_ACTIVE_HIT1, EFNSkillAnimations.EFN_GUARD_ACTIVE_HIT2,CorruptAnimations.PARRY_BREAK5)))

                    .addAdvancedGuardMotion(CorruptWeaponCategories.YAMATO,((capabilityItem, pp) ->
                    List.of(CorruptAnimations.YAMATO_ACTIVE_GUARD_HIT, CorruptAnimations.YAMATO_ACTIVE_GUARD_HIT2)));

        }
        System.out.println("EF:N PARRY Skill compat has been implemented");
    }



    @OnlyIn(Dist.CLIENT)
    public static void onIconCreate(WeaponCategoryIconRegisterEvent icon) {

        icon.registerCategory(CorruptWeaponCategories.KATANA, new ItemStack(CDAddonItems.KATANA.get()));
        icon.registerCategory(CorruptWeaponCategories.PHANTOM_KATANA, new ItemStack(CDAddonItems.PHANTOM_KATANA.get()));
        icon.registerCategory(CorruptWeaponCategories.S_LONGSWORD, new ItemStack(CDAddonItems.S_IRON_LONGSWORD.get()));
        icon.registerCategory(CorruptWeaponCategories.S_SPEAR, new ItemStack(CDAddonItems.S_IRON_SPEAR.get()));
        icon.registerCategory(CorruptWeaponCategories.S_TACHI, new ItemStack(CDAddonItems.S_IRON_TACHI.get()));
        icon.registerCategory(CorruptWeaponCategories.GREAT_TACHI, new ItemStack(CDAddonItems.GREAT_TACHI.get()));


        System.out.println("[EFNParry x EF:R] IconCreation is successfully done ");
    }

    @Override
    public void onModEventBus(IEventBus iEventBus) {
        iEventBus.addGenericListener(GuardSkill.Builder.class,
                EventPriority.NORMAL,
                EfnXOtherModsParryCompat::onEfnParrySkillCreation); // don't use this::method, it requires you to make the method not static, breaking the compat

    }

    @Override
    public void onForgeEventBus(IEventBus iEventBus) {

    }

    @Override
    public void onModEventBusClient(IEventBus iEventBus) {
        iEventBus.addListener(EfnXOtherModsParryCompat::onIconCreate);
    }

    @Override
    public void onForgeEventBusClient(IEventBus iEventBus) {

    }
}