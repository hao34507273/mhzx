/*    */ package mzm.gsp.skill.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class STLifeSkillBagLevelUpCfgInfo implements Marshal
/*    */ {
/*    */   public int id;
/*    */   public int level;
/*    */   public int needSilver;
/*    */   public int needBanggong;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 16 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/* 17 */     this.level = Integer.valueOf(rootElement.attributeValue("level")).intValue();
/* 18 */     this.needSilver = Integer.valueOf(rootElement.attributeValue("needSilver")).intValue();
/* 19 */     this.needBanggong = Integer.valueOf(rootElement.attributeValue("needBanggong")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 24 */     _os_.marshal(this.id);
/* 25 */     _os_.marshal(this.level);
/* 26 */     _os_.marshal(this.needSilver);
/* 27 */     _os_.marshal(this.needBanggong);
/* 28 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 33 */     this.id = _os_.unmarshal_int();
/* 34 */     this.level = _os_.unmarshal_int();
/* 35 */     this.needSilver = _os_.unmarshal_int();
/* 36 */     this.needBanggong = _os_.unmarshal_int();
/* 37 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\skill\confbean\STLifeSkillBagLevelUpCfgInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */