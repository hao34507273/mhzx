/*    */ package mzm.gsp.activity3.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class BackGameActivityPointGet implements Marshal
/*    */ {
/*    */   public int activityId;
/*    */   public int activityMaxCount;
/*    */   public int pointCountEachRun;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 15 */     this.activityId = Integer.valueOf(rootElement.attributeValue("activityId")).intValue();
/* 16 */     this.activityMaxCount = Integer.valueOf(rootElement.attributeValue("activityMaxCount")).intValue();
/* 17 */     this.pointCountEachRun = Integer.valueOf(rootElement.attributeValue("pointCountEachRun")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 22 */     _os_.marshal(this.activityId);
/* 23 */     _os_.marshal(this.activityMaxCount);
/* 24 */     _os_.marshal(this.pointCountEachRun);
/* 25 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 30 */     this.activityId = _os_.unmarshal_int();
/* 31 */     this.activityMaxCount = _os_.unmarshal_int();
/* 32 */     this.pointCountEachRun = _os_.unmarshal_int();
/* 33 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity3\confbean\BackGameActivityPointGet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */