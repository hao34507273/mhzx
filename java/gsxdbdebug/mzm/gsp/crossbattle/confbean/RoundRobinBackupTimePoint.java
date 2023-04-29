/*    */ package mzm.gsp.crossbattle.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class RoundRobinBackupTimePoint implements Marshal
/*    */ {
/*    */   public int round_robin_backup_time_point;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 13 */     this.round_robin_backup_time_point = Integer.valueOf(rootElement.attributeValue("round_robin_backup_time_point")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 18 */     _os_.marshal(this.round_robin_backup_time_point);
/* 19 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 24 */     this.round_robin_backup_time_point = _os_.unmarshal_int();
/* 25 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\confbean\RoundRobinBackupTimePoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */