/*    */ package mzm.gsp.item;
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
/*    */ public class SGetReceiveFlowerPointRankRes
/*    */   extends __SGetReceiveFlowerPointRankRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12584797;
/*    */   public ArrayList<ReceiveFlowerPointRankData> ranklist;
/*    */   public int mypoint;
/*    */   public int myrank;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12584797;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SGetReceiveFlowerPointRankRes()
/*    */   {
/* 33 */     this.ranklist = new ArrayList();
/*    */   }
/*    */   
/*    */   public SGetReceiveFlowerPointRankRes(ArrayList<ReceiveFlowerPointRankData> _ranklist_, int _mypoint_, int _myrank_) {
/* 37 */     this.ranklist = _ranklist_;
/* 38 */     this.mypoint = _mypoint_;
/* 39 */     this.myrank = _myrank_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     for (ReceiveFlowerPointRankData _v_ : this.ranklist)
/* 44 */       if (!_v_._validator_()) return false;
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.compact_uint32(this.ranklist.size());
/* 50 */     for (ReceiveFlowerPointRankData _v_ : this.ranklist) {
/* 51 */       _os_.marshal(_v_);
/*    */     }
/* 53 */     _os_.marshal(this.mypoint);
/* 54 */     _os_.marshal(this.myrank);
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 59 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 60 */       ReceiveFlowerPointRankData _v_ = new ReceiveFlowerPointRankData();
/* 61 */       _v_.unmarshal(_os_);
/* 62 */       this.ranklist.add(_v_);
/*    */     }
/* 64 */     this.mypoint = _os_.unmarshal_int();
/* 65 */     this.myrank = _os_.unmarshal_int();
/* 66 */     if (!_validator_()) {
/* 67 */       throw new VerifyError("validator failed");
/*    */     }
/* 69 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 73 */     if (_o1_ == this) return true;
/* 74 */     if ((_o1_ instanceof SGetReceiveFlowerPointRankRes)) {
/* 75 */       SGetReceiveFlowerPointRankRes _o_ = (SGetReceiveFlowerPointRankRes)_o1_;
/* 76 */       if (!this.ranklist.equals(_o_.ranklist)) return false;
/* 77 */       if (this.mypoint != _o_.mypoint) return false;
/* 78 */       if (this.myrank != _o_.myrank) return false;
/* 79 */       return true;
/*    */     }
/* 81 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 85 */     int _h_ = 0;
/* 86 */     _h_ += this.ranklist.hashCode();
/* 87 */     _h_ += this.mypoint;
/* 88 */     _h_ += this.myrank;
/* 89 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 93 */     StringBuilder _sb_ = new StringBuilder();
/* 94 */     _sb_.append("(");
/* 95 */     _sb_.append(this.ranklist).append(",");
/* 96 */     _sb_.append(this.mypoint).append(",");
/* 97 */     _sb_.append(this.myrank).append(",");
/* 98 */     _sb_.append(")");
/* 99 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\SGetReceiveFlowerPointRankRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */