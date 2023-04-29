/*    */ package mzm.gsp.visiblemonsterfight.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class MonsterStarLevelBean implements Marshal
/*    */ {
/*    */   public int startLevel;
/*    */   public String monsterName;
/*    */   public int fightId;
/*    */   public int awardTypeId;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 16 */     this.startLevel = Integer.valueOf(rootElement.attributeValue("startLevel")).intValue();
/* 17 */     this.monsterName = rootElement.attributeValue("monsterName");
/* 18 */     this.fightId = Integer.valueOf(rootElement.attributeValue("fightId")).intValue();
/* 19 */     this.awardTypeId = Integer.valueOf(rootElement.attributeValue("awardTypeId")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 24 */     _os_.marshal(this.startLevel);
/* 25 */     _os_.marshal(this.monsterName, "UTF-8");
/* 26 */     _os_.marshal(this.fightId);
/* 27 */     _os_.marshal(this.awardTypeId);
/* 28 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 33 */     this.startLevel = _os_.unmarshal_int();
/* 34 */     this.monsterName = _os_.unmarshal_String("UTF-8");
/* 35 */     this.fightId = _os_.unmarshal_int();
/* 36 */     this.awardTypeId = _os_.unmarshal_int();
/* 37 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\visiblemonsterfight\confbean\MonsterStarLevelBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */