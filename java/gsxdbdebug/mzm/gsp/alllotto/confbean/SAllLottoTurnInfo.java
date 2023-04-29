/*    */ package mzm.gsp.alllotto.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class SAllLottoTurnInfo implements Marshal
/*    */ {
/*    */   public int timestamp;
/*    */   public int fix_award_id;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 14 */     this.timestamp = Integer.valueOf(rootElement.attributeValue("timestamp")).intValue();
/* 15 */     this.fix_award_id = Integer.valueOf(rootElement.attributeValue("fix_award_id")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 20 */     _os_.marshal(this.timestamp);
/* 21 */     _os_.marshal(this.fix_award_id);
/* 22 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 27 */     this.timestamp = _os_.unmarshal_int();
/* 28 */     this.fix_award_id = _os_.unmarshal_int();
/* 29 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\alllotto\confbean\SAllLottoTurnInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */