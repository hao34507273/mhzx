/*    */ package mzm.gsp.partner;
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
/*    */ public class SShuffleLovesReq
/*    */   extends __SShuffleLovesReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12588034;
/*    */   public int partnerid;
/*    */   public ArrayList<Integer> lovestoreplace;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12588034;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SShuffleLovesReq()
/*    */   {
/* 34 */     this.lovestoreplace = new ArrayList();
/*    */   }
/*    */   
/*    */   public SShuffleLovesReq(int _partnerid_, ArrayList<Integer> _lovestoreplace_) {
/* 38 */     this.partnerid = _partnerid_;
/* 39 */     this.lovestoreplace = _lovestoreplace_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.marshal(this.partnerid);
/* 48 */     _os_.compact_uint32(this.lovestoreplace.size());
/* 49 */     for (Integer _v_ : this.lovestoreplace) {
/* 50 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.partnerid = _os_.unmarshal_int();
/* 57 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 59 */       int _v_ = _os_.unmarshal_int();
/* 60 */       this.lovestoreplace.add(Integer.valueOf(_v_));
/*    */     }
/* 62 */     if (!_validator_()) {
/* 63 */       throw new VerifyError("validator failed");
/*    */     }
/* 65 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 69 */     if (_o1_ == this) return true;
/* 70 */     if ((_o1_ instanceof SShuffleLovesReq)) {
/* 71 */       SShuffleLovesReq _o_ = (SShuffleLovesReq)_o1_;
/* 72 */       if (this.partnerid != _o_.partnerid) return false;
/* 73 */       if (!this.lovestoreplace.equals(_o_.lovestoreplace)) return false;
/* 74 */       return true;
/*    */     }
/* 76 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 80 */     int _h_ = 0;
/* 81 */     _h_ += this.partnerid;
/* 82 */     _h_ += this.lovestoreplace.hashCode();
/* 83 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 87 */     StringBuilder _sb_ = new StringBuilder();
/* 88 */     _sb_.append("(");
/* 89 */     _sb_.append(this.partnerid).append(",");
/* 90 */     _sb_.append(this.lovestoreplace).append(",");
/* 91 */     _sb_.append(")");
/* 92 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\partner\SShuffleLovesReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */