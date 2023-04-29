/*    */ package mzm.gsp.menpaipvp.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class MenpaiRankAward implements Marshal
/*    */ {
/*    */   public int gender;
/*    */   public int appellation;
/*    */   public int mail;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 15 */     this.gender = Integer.valueOf(rootElement.attributeValue("gender")).intValue();
/* 16 */     this.appellation = Integer.valueOf(rootElement.attributeValue("appellation")).intValue();
/* 17 */     this.mail = Integer.valueOf(rootElement.attributeValue("mail")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 22 */     _os_.marshal(this.gender);
/* 23 */     _os_.marshal(this.appellation);
/* 24 */     _os_.marshal(this.mail);
/* 25 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 30 */     this.gender = _os_.unmarshal_int();
/* 31 */     this.appellation = _os_.unmarshal_int();
/* 32 */     this.mail = _os_.unmarshal_int();
/* 33 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaipvp\confbean\MenpaiRankAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */