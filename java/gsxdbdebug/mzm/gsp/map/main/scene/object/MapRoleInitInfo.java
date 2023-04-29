/*     */ package mzm.gsp.map.main.scene.object;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.aircraft.main.AircraftInterface;
/*     */ import mzm.gsp.children.main.ChildrenInterface;
/*     */ import mzm.gsp.children.main.ChildrenInterface.ShowChildObj;
/*     */ import mzm.gsp.feijian.confbean.SFeiJianCfg;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.map.MapModelInfo;
/*     */ import mzm.gsp.map.main.MapManager;
/*     */ import mzm.gsp.map.main.scene.Position;
/*     */ import mzm.gsp.mounts.main.MountsInterface;
/*     */ import mzm.gsp.mounts.main.MountsInterface.RideMountsObj;
/*     */ import mzm.gsp.pet.main.Pet;
/*     */ import mzm.gsp.pet.main.PetInterface;
/*     */ import mzm.gsp.role.main.Occupation;
/*     */ import mzm.gsp.role.main.Role;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.task.main.TaskInterface;
/*     */ import mzm.gsp.task.main.TaskInterface.TaskState;
/*     */ import mzm.gsp.title.main.ActiveInfo;
/*     */ import mzm.gsp.title.main.TitleInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MapRoleInitInfo
/*     */ {
/*     */   public int velocity;
/*     */   public int mountsSpeed;
/*     */   public int flySpeed;
/*     */   public int modelId;
/*     */   public String name;
/*     */   public int dyeColorId;
/*     */   public int level;
/*     */   public int menPai;
/*     */   public int gender;
/*     */   public Position position;
/*     */   public int defaultBornMapid;
/*     */   public int defaultBornX;
/*     */   public int defaultBornY;
/*     */   public MapModelInfo roleModelInfo;
/*     */   public MapModelInfo petModelInfo;
/*     */   public MapModelInfo childrenModelInfo;
/*     */   public Set<Integer> roleStatusSet;
/*     */   public Map<Integer, TaskInterface.TaskState> taskStateMap;
/*     */   
/*     */   public MapRoleInitInfo(long roleid)
/*     */   {
/* 130 */     Role role = RoleInterface.getRole(roleid, true);
/* 131 */     this.velocity = role.getVelocity();
/* 132 */     this.modelId = role.getModelId();
/* 133 */     this.name = role.getName();
/* 134 */     this.dyeColorId = role.getColorId();
/* 135 */     this.level = role.getLevel();
/* 136 */     this.menPai = role.getOccupationId();
/* 137 */     this.gender = role.getGender();
/* 138 */     this.position = role.getPosition();
/* 139 */     this.taskStateMap = TaskInterface.getAllRoleTaskBean(roleid, true);
/*     */     
/* 141 */     Occupation ocp = RoleInterface.getOccupation(role.getOccupationId(), role.getGender());
/* 142 */     this.defaultBornMapid = ocp.getBornMapId();
/* 143 */     this.defaultBornX = ocp.getBornMapX();
/* 144 */     this.defaultBornY = ocp.getBornMapY();
/*     */     
/*     */ 
/* 147 */     MapModelInfo mapModelInfo = new MapModelInfo();
/* 148 */     this.roleModelInfo = mapModelInfo;
/*     */     
/*     */ 
/* 151 */     mapModelInfo.id = roleid;
/*     */     
/* 153 */     mapModelInfo.string_props.put(Integer.valueOf(0), role.getName());
/*     */     
/*     */ 
/* 156 */     RoleInterface.fillModelInfo(roleid, mapModelInfo.model);
/*     */     
/*     */ 
/* 159 */     ActiveInfo title = TitleInterface.getActiveTitilId(roleid);
/* 160 */     if (title != null)
/*     */     {
/* 162 */       int activeTitleid = title.getActiveId();
/* 163 */       if (activeTitleid > 0)
/*     */       {
/* 165 */         mapModelInfo.int_props.put(Integer.valueOf(0), Integer.valueOf(activeTitleid));
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 170 */     ActiveInfo appellation = TitleInterface.getActiveAppellationId(roleid);
/* 171 */     if (appellation != null)
/*     */     {
/* 173 */       int appellationActiveid = appellation.getActiveId();
/* 174 */       if (appellationActiveid > 0)
/*     */       {
/* 176 */         mapModelInfo.int_props.put(Integer.valueOf(1), Integer.valueOf(appellationActiveid));
/* 177 */         mapModelInfo.string_props.put(Integer.valueOf(1), appellation.getName());
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 182 */     MountsInterface.RideMountsObj rideMountsObj = MountsInterface.getRideMountsObj(roleid, true);
/* 183 */     if (rideMountsObj != null)
/*     */     {
/* 185 */       this.mountsSpeed = rideMountsObj.getMountsSpeed();
/*     */     }
/*     */     
/*     */ 
/* 189 */     mapModelInfo.velocity = (this.mountsSpeed > 0 ? this.mountsSpeed : this.velocity);
/*     */     
/*     */ 
/* 192 */     if (RoleStatusInterface.containsStatus(roleid, 2))
/*     */     {
/* 194 */       int feijianid = AircraftInterface.getEquipedFeiJianCfgId(roleid, true);
/* 195 */       if (feijianid <= 0)
/*     */       {
/* 197 */         RoleStatusInterface.unsetStatus(roleid, 2);
/*     */       }
/*     */       else
/*     */       {
/* 201 */         SFeiJianCfg feiJianCfg = ItemInterface.getFeiJianCfg(feijianid);
/* 202 */         if (feiJianCfg != null)
/*     */         {
/* 204 */           this.flySpeed = feiJianCfg.velocity;
/*     */         }
/*     */         else
/*     */         {
/* 208 */           RoleStatusInterface.unsetStatus(roleid, 2);
/* 209 */           GameServer.logger().error(String.format("[map]MapRoleInitInfo.MapRoleInitInfo@fei jian config is not exist|roleid=%d|config=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(feijianid) }));
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 218 */     this.roleStatusSet = RoleStatusInterface.getStatusSet(roleid);
/* 219 */     Set<Integer> statusSet = RoleStatusInterface.getToClientAllStatus(roleid, true);
/* 220 */     mapModelInfo.role_status_list.addAll(statusSet);
/*     */     
/* 222 */     Pet pet = PetInterface.getShowPet(roleid, true);
/* 223 */     if (pet == null)
/*     */     {
/* 225 */       this.petModelInfo = null;
/*     */       
/* 227 */       ChildrenInterface.ShowChildObj showChildObj = ChildrenInterface.getShowChildObj(roleid, true);
/* 228 */       if (showChildObj == null)
/*     */       {
/* 230 */         this.childrenModelInfo = null;
/*     */       }
/*     */       else
/*     */       {
/* 234 */         this.childrenModelInfo = MapManager.boxChildrenModelInfo(showChildObj);
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/* 239 */       this.petModelInfo = new MapModelInfo();
/* 240 */       pet.getMapModel(this.petModelInfo);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\scene\object\MapRoleInitInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */