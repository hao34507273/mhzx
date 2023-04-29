/*    */ package mzm.gsp.gratefuldelivery.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class SStageInformation implements Marshal
/*    */ {
/*    */   public int count;
/*    */   public int rewardId;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 14 */     this.count = Integer.valueOf(rootElement.attributeValue("count")).intValue();
/* 15 */     this.rewardId = Integer.valueOf(rootElement.attributeValue("rewardId")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 20 */     _os_.marshal(this.count);
/* 21 */     _os_.marshal(this.rewardId);
/* 22 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 27 */     this.count = _os_.unmarshal_int();
/* 28 */     this.rewardId = _os_.unmarshal_int();
/* 29 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gratefuldelivery\confbean\SStageInformation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */