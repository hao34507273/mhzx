/*    */ package mzm.gsp.monster.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class SBaseBrightMonster implements Marshal
/*    */ {
/*    */   public int id;
/*    */   public String templatename;
/*    */   public String name;
/*    */   public int maxKilledTimes;
/*    */   public int killedEffect;
/*    */   public boolean isInAir;
/*    */   public int velocity;
/*    */   public int enterFightMinRoleNum;
/*    */   public int enterFightMaxRoleNum;
/*    */   public int enterFightLevelType;
/*    */   public int enterFightMinLevel;
/*    */   public int enterFightMaxLevel;
/*    */   public int monsterModelTableId;
/*    */   public int monsterFightTableId;
/*    */   public int controllerId;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 27 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/* 28 */     this.templatename = rootElement.attributeValue("templatename");
/* 29 */     this.name = rootElement.attributeValue("name");
/* 30 */     this.maxKilledTimes = Integer.valueOf(rootElement.attributeValue("maxKilledTimes")).intValue();
/* 31 */     this.killedEffect = Integer.valueOf(rootElement.attributeValue("killedEffect")).intValue();
/* 32 */     this.isInAir = Boolean.valueOf(rootElement.attributeValue("isInAir")).booleanValue();
/* 33 */     this.velocity = Integer.valueOf(rootElement.attributeValue("velocity")).intValue();
/* 34 */     this.enterFightMinRoleNum = Integer.valueOf(rootElement.attributeValue("enterFightMinRoleNum")).intValue();
/* 35 */     this.enterFightMaxRoleNum = Integer.valueOf(rootElement.attributeValue("enterFightMaxRoleNum")).intValue();
/* 36 */     this.enterFightLevelType = Integer.valueOf(rootElement.attributeValue("enterFightLevelType")).intValue();
/* 37 */     this.enterFightMinLevel = Integer.valueOf(rootElement.attributeValue("enterFightMinLevel")).intValue();
/* 38 */     this.enterFightMaxLevel = Integer.valueOf(rootElement.attributeValue("enterFightMaxLevel")).intValue();
/* 39 */     this.monsterModelTableId = Integer.valueOf(rootElement.attributeValue("monsterModelTableId")).intValue();
/* 40 */     this.monsterFightTableId = Integer.valueOf(rootElement.attributeValue("monsterFightTableId")).intValue();
/* 41 */     this.controllerId = Integer.valueOf(rootElement.attributeValue("controllerId")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 46 */     _os_.marshal(this.id);
/* 47 */     _os_.marshal(this.templatename, "UTF-8");
/* 48 */     _os_.marshal(this.name, "UTF-8");
/* 49 */     _os_.marshal(this.maxKilledTimes);
/* 50 */     _os_.marshal(this.killedEffect);
/* 51 */     _os_.marshal(this.isInAir);
/* 52 */     _os_.marshal(this.velocity);
/* 53 */     _os_.marshal(this.enterFightMinRoleNum);
/* 54 */     _os_.marshal(this.enterFightMaxRoleNum);
/* 55 */     _os_.marshal(this.enterFightLevelType);
/* 56 */     _os_.marshal(this.enterFightMinLevel);
/* 57 */     _os_.marshal(this.enterFightMaxLevel);
/* 58 */     _os_.marshal(this.monsterModelTableId);
/* 59 */     _os_.marshal(this.monsterFightTableId);
/* 60 */     _os_.marshal(this.controllerId);
/* 61 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 66 */     this.id = _os_.unmarshal_int();
/* 67 */     this.templatename = _os_.unmarshal_String("UTF-8");
/* 68 */     this.name = _os_.unmarshal_String("UTF-8");
/* 69 */     this.maxKilledTimes = _os_.unmarshal_int();
/* 70 */     this.killedEffect = _os_.unmarshal_int();
/* 71 */     this.isInAir = _os_.unmarshal_boolean();
/* 72 */     this.velocity = _os_.unmarshal_int();
/* 73 */     this.enterFightMinRoleNum = _os_.unmarshal_int();
/* 74 */     this.enterFightMaxRoleNum = _os_.unmarshal_int();
/* 75 */     this.enterFightLevelType = _os_.unmarshal_int();
/* 76 */     this.enterFightMinLevel = _os_.unmarshal_int();
/* 77 */     this.enterFightMaxLevel = _os_.unmarshal_int();
/* 78 */     this.monsterModelTableId = _os_.unmarshal_int();
/* 79 */     this.monsterFightTableId = _os_.unmarshal_int();
/* 80 */     this.controllerId = _os_.unmarshal_int();
/* 81 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\monster\confbean\SBaseBrightMonster.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */