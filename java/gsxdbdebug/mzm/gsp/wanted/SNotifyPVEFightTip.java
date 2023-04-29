/*    */ package mzm.gsp.wanted;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashSet;
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
/*    */ public class SNotifyPVEFightTip
/*    */   extends __SNotifyPVEFightTip__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12620295;
/*    */   public int fightcount;
/*    */   public HashSet<Long> wantedidset;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12620295;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SNotifyPVEFightTip()
/*    */   {
/* 34 */     this.wantedidset = new HashSet();
/*    */   }
/*    */   
/*    */   public SNotifyPVEFightTip(int _fightcount_, HashSet<Long> _wantedidset_) {
/* 38 */     this.fightcount = _fightcount_;
/* 39 */     this.wantedidset = _wantedidset_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.marshal(this.fightcount);
/* 48 */     _os_.compact_uint32(this.wantedidset.size());
/* 49 */     for (Long _v_ : this.wantedidset) {
/* 50 */       _os_.marshal(_v_.longValue());
/*    */     }
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.fightcount = _os_.unmarshal_int();
/* 57 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 59 */       long _v_ = _os_.unmarshal_long();
/* 60 */       this.wantedidset.add(Long.valueOf(_v_));
/*    */     }
/* 62 */     if (!_validator_()) {
/* 63 */       throw new VerifyError("validator failed");
/*    */     }
/* 65 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 69 */     if (_o1_ == this) return true;
/* 70 */     if ((_o1_ instanceof SNotifyPVEFightTip)) {
/* 71 */       SNotifyPVEFightTip _o_ = (SNotifyPVEFightTip)_o1_;
/* 72 */       if (this.fightcount != _o_.fightcount) return false;
/* 73 */       if (!this.wantedidset.equals(_o_.wantedidset)) return false;
/* 74 */       return true;
/*    */     }
/* 76 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 80 */     int _h_ = 0;
/* 81 */     _h_ += this.fightcount;
/* 82 */     _h_ += this.wantedidset.hashCode();
/* 83 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 87 */     StringBuilder _sb_ = new StringBuilder();
/* 88 */     _sb_.append("(");
/* 89 */     _sb_.append(this.fightcount).append(",");
/* 90 */     _sb_.append(this.wantedidset).append(",");
/* 91 */     _sb_.append(")");
/* 92 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wanted\SNotifyPVEFightTip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */