/*    */ package mzm.gsp.mall;
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
/*    */ public class SAllMallItemNum
/*    */   extends __SAllMallItemNum__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12585475;
/*    */   public ArrayList<MallItemInfo> mallitemlist;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12585475;
/*    */   }
/*    */   
/*    */ 
/*    */   public SAllMallItemNum()
/*    */   {
/* 33 */     this.mallitemlist = new ArrayList();
/*    */   }
/*    */   
/*    */   public SAllMallItemNum(ArrayList<MallItemInfo> _mallitemlist_) {
/* 37 */     this.mallitemlist = _mallitemlist_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     for (MallItemInfo _v_ : this.mallitemlist)
/* 42 */       if (!_v_._validator_()) return false;
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.compact_uint32(this.mallitemlist.size());
/* 48 */     for (MallItemInfo _v_ : this.mallitemlist) {
/* 49 */       _os_.marshal(_v_);
/*    */     }
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 55 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 56 */       MallItemInfo _v_ = new MallItemInfo();
/* 57 */       _v_.unmarshal(_os_);
/* 58 */       this.mallitemlist.add(_v_);
/*    */     }
/* 60 */     if (!_validator_()) {
/* 61 */       throw new VerifyError("validator failed");
/*    */     }
/* 63 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 67 */     if (_o1_ == this) return true;
/* 68 */     if ((_o1_ instanceof SAllMallItemNum)) {
/* 69 */       SAllMallItemNum _o_ = (SAllMallItemNum)_o1_;
/* 70 */       if (!this.mallitemlist.equals(_o_.mallitemlist)) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += this.mallitemlist.hashCode();
/* 79 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 83 */     StringBuilder _sb_ = new StringBuilder();
/* 84 */     _sb_.append("(");
/* 85 */     _sb_.append(this.mallitemlist).append(",");
/* 86 */     _sb_.append(")");
/* 87 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mall\SAllMallItemNum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */