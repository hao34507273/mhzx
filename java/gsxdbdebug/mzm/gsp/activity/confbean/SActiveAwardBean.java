/*    */ package mzm.gsp.activity.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class SActiveAwardBean implements Marshal
/*    */ {
/*    */   public int active_value;
/*    */   public int award_id;
/*    */   public int is_bind;
/*    */   public int cfg_id;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 16 */     this.active_value = Integer.valueOf(rootElement.attributeValue("active_value")).intValue();
/* 17 */     this.award_id = Integer.valueOf(rootElement.attributeValue("award_id")).intValue();
/* 18 */     this.is_bind = Integer.valueOf(rootElement.attributeValue("is_bind")).intValue();
/* 19 */     this.cfg_id = Integer.valueOf(rootElement.attributeValue("cfg_id")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 24 */     _os_.marshal(this.active_value);
/* 25 */     _os_.marshal(this.award_id);
/* 26 */     _os_.marshal(this.is_bind);
/* 27 */     _os_.marshal(this.cfg_id);
/* 28 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 33 */     this.active_value = _os_.unmarshal_int();
/* 34 */     this.award_id = _os_.unmarshal_int();
/* 35 */     this.is_bind = _os_.unmarshal_int();
/* 36 */     this.cfg_id = _os_.unmarshal_int();
/* 37 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\confbean\SActiveAwardBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */