/*    */ package mzm.gsp.item;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.item.main.PCUseGeniusStoneItem;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CUseGeniusStoneItem
/*    */   extends __CUseGeniusStoneItem__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12584870;
/*    */   public long uuid;
/*    */   public byte use_all;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     if (roleId < 1L)
/*    */     {
/* 22 */       return;
/*    */     }
/* 24 */     Role.addRoleProcedure(roleId, new PCUseGeniusStoneItem(roleId, this.uuid, this.use_all == 1));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 32 */     return 12584870;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CUseGeniusStoneItem() {}
/*    */   
/*    */ 
/*    */   public CUseGeniusStoneItem(long _uuid_, byte _use_all_)
/*    */   {
/* 42 */     this.uuid = _uuid_;
/* 43 */     this.use_all = _use_all_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.uuid);
/* 52 */     _os_.marshal(this.use_all);
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     this.uuid = _os_.unmarshal_long();
/* 58 */     this.use_all = _os_.unmarshal_byte();
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof CUseGeniusStoneItem)) {
/* 68 */       CUseGeniusStoneItem _o_ = (CUseGeniusStoneItem)_o1_;
/* 69 */       if (this.uuid != _o_.uuid) return false;
/* 70 */       if (this.use_all != _o_.use_all) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += (int)this.uuid;
/* 79 */     _h_ += this.use_all;
/* 80 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 84 */     StringBuilder _sb_ = new StringBuilder();
/* 85 */     _sb_.append("(");
/* 86 */     _sb_.append(this.uuid).append(",");
/* 87 */     _sb_.append(this.use_all).append(",");
/* 88 */     _sb_.append(")");
/* 89 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CUseGeniusStoneItem _o_) {
/* 93 */     if (_o_ == this) return 0;
/* 94 */     int _c_ = 0;
/* 95 */     _c_ = Long.signum(this.uuid - _o_.uuid);
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     _c_ = this.use_all - _o_.use_all;
/* 98 */     if (0 != _c_) return _c_;
/* 99 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\CUseGeniusStoneItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */