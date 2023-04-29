/*    */ package mzm.gsp.activity2.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class ControllerIdBean implements Marshal
/*    */ {
/*    */   public int controllerId;
/*    */   public int refreshSeconds;
/*    */   public int triggerMonsterId;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 15 */     this.controllerId = Integer.valueOf(rootElement.attributeValue("controllerId")).intValue();
/* 16 */     this.refreshSeconds = Integer.valueOf(rootElement.attributeValue("refreshSeconds")).intValue();
/* 17 */     this.triggerMonsterId = Integer.valueOf(rootElement.attributeValue("triggerMonsterId")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 22 */     _os_.marshal(this.controllerId);
/* 23 */     _os_.marshal(this.refreshSeconds);
/* 24 */     _os_.marshal(this.triggerMonsterId);
/* 25 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 30 */     this.controllerId = _os_.unmarshal_int();
/* 31 */     this.refreshSeconds = _os_.unmarshal_int();
/* 32 */     this.triggerMonsterId = _os_.unmarshal_int();
/* 33 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity2\confbean\ControllerIdBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */