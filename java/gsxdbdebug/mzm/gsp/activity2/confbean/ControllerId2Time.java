/*    */ package mzm.gsp.activity2.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class ControllerId2Time implements Marshal
/*    */ {
/*    */   public int controllerId;
/*    */   public int refreshSeconds;
/*    */   public String bornNotice;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 15 */     this.controllerId = Integer.valueOf(rootElement.attributeValue("controllerId")).intValue();
/* 16 */     this.refreshSeconds = Integer.valueOf(rootElement.attributeValue("refreshSeconds")).intValue();
/* 17 */     this.bornNotice = rootElement.attributeValue("bornNotice");
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 21 */     _os_.marshal(this.controllerId);
/* 22 */     _os_.marshal(this.refreshSeconds);
/* 23 */     _os_.marshal(this.bornNotice, "UTF-8");
/* 24 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 28 */     this.controllerId = _os_.unmarshal_int();
/* 29 */     this.refreshSeconds = _os_.unmarshal_int();
/* 30 */     this.bornNotice = _os_.unmarshal_String("UTF-8");
/* 31 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity2\confbean\ControllerId2Time.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */