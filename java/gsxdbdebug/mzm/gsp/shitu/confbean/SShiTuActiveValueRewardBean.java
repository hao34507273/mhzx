/*    */ package mzm.gsp.shitu.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class SShiTuActiveValueRewardBean implements Marshal
/*    */ {
/*    */   public int activite_value;
/*    */   public int award_id;
/*    */   public int is_bind;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 15 */     this.activite_value = Integer.valueOf(rootElement.attributeValue("activite_value")).intValue();
/* 16 */     this.award_id = Integer.valueOf(rootElement.attributeValue("award_id")).intValue();
/* 17 */     this.is_bind = Integer.valueOf(rootElement.attributeValue("is_bind")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 22 */     _os_.marshal(this.activite_value);
/* 23 */     _os_.marshal(this.award_id);
/* 24 */     _os_.marshal(this.is_bind);
/* 25 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 30 */     this.activite_value = _os_.unmarshal_int();
/* 31 */     this.award_id = _os_.unmarshal_int();
/* 32 */     this.is_bind = _os_.unmarshal_int();
/* 33 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\confbean\SShiTuActiveValueRewardBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */