/*    */ package mzm.gsp.award;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
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
/*    */ 
/*    */ public class SCanGetGiftAward
/*    */   extends __SCanGetGiftAward__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12583443;
/*    */   public ArrayList<Integer> giftawardcfgids;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12583443;
/*    */   }
/*    */   
/*    */ 
/*    */   public SCanGetGiftAward()
/*    */   {
/* 33 */     this.giftawardcfgids = new ArrayList();
/*    */   }
/*    */   
/*    */   public SCanGetGiftAward(ArrayList<Integer> _giftawardcfgids_) {
/* 37 */     this.giftawardcfgids = _giftawardcfgids_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 45 */     _os_.compact_uint32(this.giftawardcfgids.size());
/* 46 */     for (Integer _v_ : this.giftawardcfgids) {
/* 47 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 53 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 55 */       int _v_ = _os_.unmarshal_int();
/* 56 */       this.giftawardcfgids.add(Integer.valueOf(_v_));
/*    */     }
/* 58 */     if (!_validator_()) {
/* 59 */       throw new VerifyError("validator failed");
/*    */     }
/* 61 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 65 */     if (_o1_ == this) return true;
/* 66 */     if ((_o1_ instanceof SCanGetGiftAward)) {
/* 67 */       SCanGetGiftAward _o_ = (SCanGetGiftAward)_o1_;
/* 68 */       if (!this.giftawardcfgids.equals(_o_.giftawardcfgids)) return false;
/* 69 */       return true;
/*    */     }
/* 71 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 75 */     int _h_ = 0;
/* 76 */     _h_ += this.giftawardcfgids.hashCode();
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.giftawardcfgids).append(",");
/* 84 */     _sb_.append(")");
/* 85 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\SCanGetGiftAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */