/*    */ package mzm.gsp.award.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class AddCfgBean implements Marshal
/*    */ {
/*    */   public int awardType;
/*    */   public boolean isEff;
/*    */   public int effConId;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 15 */     this.awardType = Integer.valueOf(rootElement.attributeValue("awardType")).intValue();
/* 16 */     this.isEff = Boolean.valueOf(rootElement.attributeValue("isEff")).booleanValue();
/* 17 */     this.effConId = Integer.valueOf(rootElement.attributeValue("effConId")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 22 */     _os_.marshal(this.awardType);
/* 23 */     _os_.marshal(this.isEff);
/* 24 */     _os_.marshal(this.effConId);
/* 25 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 30 */     this.awardType = _os_.unmarshal_int();
/* 31 */     this.isEff = _os_.unmarshal_boolean();
/* 32 */     this.effConId = _os_.unmarshal_int();
/* 33 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\confbean\AddCfgBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */