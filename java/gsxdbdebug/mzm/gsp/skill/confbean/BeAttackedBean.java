/*    */ package mzm.gsp.skill.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class BeAttackedBean implements Marshal
/*    */ {
/*    */   public int beAttackedTime;
/*    */   public int shock;
/*    */   public int beAttackedAction;
/*    */   public int beAttackedActionid;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 16 */     this.beAttackedTime = Integer.valueOf(rootElement.attributeValue("beAttackedTime")).intValue();
/* 17 */     this.shock = Integer.valueOf(rootElement.attributeValue("shock")).intValue();
/* 18 */     this.beAttackedAction = Integer.valueOf(rootElement.attributeValue("beAttackedAction")).intValue();
/* 19 */     this.beAttackedActionid = Integer.valueOf(rootElement.attributeValue("beAttackedActionid")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 24 */     _os_.marshal(this.beAttackedTime);
/* 25 */     _os_.marshal(this.shock);
/* 26 */     _os_.marshal(this.beAttackedAction);
/* 27 */     _os_.marshal(this.beAttackedActionid);
/* 28 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 33 */     this.beAttackedTime = _os_.unmarshal_int();
/* 34 */     this.shock = _os_.unmarshal_int();
/* 35 */     this.beAttackedAction = _os_.unmarshal_int();
/* 36 */     this.beAttackedActionid = _os_.unmarshal_int();
/* 37 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\skill\confbean\BeAttackedBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */