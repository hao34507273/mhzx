/*    */ package mzm.gsp.instance.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class OperaInstanceProcessCfg implements Marshal
/*    */ {
/*    */   public int instanceid;
/*    */   public int opentaskid;
/*    */   public int taskid;
/*    */   public int awardid;
/*    */   public int in_mapid;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 17 */     this.instanceid = Integer.valueOf(rootElement.attributeValue("instanceid")).intValue();
/* 18 */     this.opentaskid = Integer.valueOf(rootElement.attributeValue("opentaskid")).intValue();
/* 19 */     this.taskid = Integer.valueOf(rootElement.attributeValue("taskid")).intValue();
/* 20 */     this.awardid = Integer.valueOf(rootElement.attributeValue("awardid")).intValue();
/* 21 */     this.in_mapid = Integer.valueOf(rootElement.attributeValue("in_mapid")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 26 */     _os_.marshal(this.instanceid);
/* 27 */     _os_.marshal(this.opentaskid);
/* 28 */     _os_.marshal(this.taskid);
/* 29 */     _os_.marshal(this.awardid);
/* 30 */     _os_.marshal(this.in_mapid);
/* 31 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 36 */     this.instanceid = _os_.unmarshal_int();
/* 37 */     this.opentaskid = _os_.unmarshal_int();
/* 38 */     this.taskid = _os_.unmarshal_int();
/* 39 */     this.awardid = _os_.unmarshal_int();
/* 40 */     this.in_mapid = _os_.unmarshal_int();
/* 41 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\instance\confbean\OperaInstanceProcessCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */