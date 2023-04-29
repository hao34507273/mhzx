/*    */ package mzm.gsp.chat;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.item.ItemInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SPacketFaBaoInChatInfo
/*    */   extends __SPacketFaBaoInChatInfo__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12585243;
/*    */   public long checkedroleid;
/*    */   public ItemInfo iteminfo;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12585243;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SPacketFaBaoInChatInfo()
/*    */   {
/* 34 */     this.iteminfo = new ItemInfo();
/*    */   }
/*    */   
/*    */   public SPacketFaBaoInChatInfo(long _checkedroleid_, ItemInfo _iteminfo_) {
/* 38 */     this.checkedroleid = _checkedroleid_;
/* 39 */     this.iteminfo = _iteminfo_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     if (!this.iteminfo._validator_()) return false;
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.checkedroleid);
/* 49 */     _os_.marshal(this.iteminfo);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.checkedroleid = _os_.unmarshal_long();
/* 55 */     this.iteminfo.unmarshal(_os_);
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof SPacketFaBaoInChatInfo)) {
/* 65 */       SPacketFaBaoInChatInfo _o_ = (SPacketFaBaoInChatInfo)_o1_;
/* 66 */       if (this.checkedroleid != _o_.checkedroleid) return false;
/* 67 */       if (!this.iteminfo.equals(_o_.iteminfo)) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += (int)this.checkedroleid;
/* 76 */     _h_ += this.iteminfo.hashCode();
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.checkedroleid).append(",");
/* 84 */     _sb_.append(this.iteminfo).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\SPacketFaBaoInChatInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */