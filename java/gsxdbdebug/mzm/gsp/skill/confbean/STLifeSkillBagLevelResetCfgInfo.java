/*    */ package mzm.gsp.skill.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class STLifeSkillBagLevelResetCfgInfo implements Marshal
/*    */ {
/*    */   public int returnSilver;
/*    */   public int returnBanggong;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 14 */     this.returnSilver = Integer.valueOf(rootElement.attributeValue("returnSilver")).intValue();
/* 15 */     this.returnBanggong = Integer.valueOf(rootElement.attributeValue("returnBanggong")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 20 */     _os_.marshal(this.returnSilver);
/* 21 */     _os_.marshal(this.returnBanggong);
/* 22 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 27 */     this.returnSilver = _os_.unmarshal_int();
/* 28 */     this.returnBanggong = _os_.unmarshal_int();
/* 29 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\skill\confbean\STLifeSkillBagLevelResetCfgInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */