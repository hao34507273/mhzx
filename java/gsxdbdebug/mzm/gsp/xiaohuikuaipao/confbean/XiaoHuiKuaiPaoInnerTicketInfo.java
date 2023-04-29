/*    */ package mzm.gsp.xiaohuikuaipao.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class XiaoHuiKuaiPaoInnerTicketInfo implements Marshal
/*    */ {
/*    */   public int activityId;
/*    */   public int accumulateTurnCount;
/*    */   public int ticketCount;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 15 */     this.activityId = Integer.valueOf(rootElement.attributeValue("activityId")).intValue();
/* 16 */     this.accumulateTurnCount = Integer.valueOf(rootElement.attributeValue("accumulateTurnCount")).intValue();
/* 17 */     this.ticketCount = Integer.valueOf(rootElement.attributeValue("ticketCount")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 22 */     _os_.marshal(this.activityId);
/* 23 */     _os_.marshal(this.accumulateTurnCount);
/* 24 */     _os_.marshal(this.ticketCount);
/* 25 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 30 */     this.activityId = _os_.unmarshal_int();
/* 31 */     this.accumulateTurnCount = _os_.unmarshal_int();
/* 32 */     this.ticketCount = _os_.unmarshal_int();
/* 33 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\xiaohuikuaipao\confbean\XiaoHuiKuaiPaoInnerTicketInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */