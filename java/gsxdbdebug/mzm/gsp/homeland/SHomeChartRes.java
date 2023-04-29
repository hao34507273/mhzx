/*    */ package mzm.gsp.homeland;
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
/*    */ public class SHomeChartRes
/*    */   extends __SHomeChartRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12605494;
/*    */   public int point;
/*    */   public int myrank;
/*    */   public ArrayList<HomeRankData> ranklist;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12605494;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SHomeChartRes()
/*    */   {
/* 33 */     this.ranklist = new ArrayList();
/*    */   }
/*    */   
/*    */   public SHomeChartRes(int _point_, int _myrank_, ArrayList<HomeRankData> _ranklist_) {
/* 37 */     this.point = _point_;
/* 38 */     this.myrank = _myrank_;
/* 39 */     this.ranklist = _ranklist_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     for (HomeRankData _v_ : this.ranklist)
/* 44 */       if (!_v_._validator_()) return false;
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.point);
/* 50 */     _os_.marshal(this.myrank);
/* 51 */     _os_.compact_uint32(this.ranklist.size());
/* 52 */     for (HomeRankData _v_ : this.ranklist) {
/* 53 */       _os_.marshal(_v_);
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 59 */     this.point = _os_.unmarshal_int();
/* 60 */     this.myrank = _os_.unmarshal_int();
/* 61 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 62 */       HomeRankData _v_ = new HomeRankData();
/* 63 */       _v_.unmarshal(_os_);
/* 64 */       this.ranklist.add(_v_);
/*    */     }
/* 66 */     if (!_validator_()) {
/* 67 */       throw new VerifyError("validator failed");
/*    */     }
/* 69 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 73 */     if (_o1_ == this) return true;
/* 74 */     if ((_o1_ instanceof SHomeChartRes)) {
/* 75 */       SHomeChartRes _o_ = (SHomeChartRes)_o1_;
/* 76 */       if (this.point != _o_.point) return false;
/* 77 */       if (this.myrank != _o_.myrank) return false;
/* 78 */       if (!this.ranklist.equals(_o_.ranklist)) return false;
/* 79 */       return true;
/*    */     }
/* 81 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 85 */     int _h_ = 0;
/* 86 */     _h_ += this.point;
/* 87 */     _h_ += this.myrank;
/* 88 */     _h_ += this.ranklist.hashCode();
/* 89 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 93 */     StringBuilder _sb_ = new StringBuilder();
/* 94 */     _sb_.append("(");
/* 95 */     _sb_.append(this.point).append(",");
/* 96 */     _sb_.append(this.myrank).append(",");
/* 97 */     _sb_.append(this.ranklist).append(",");
/* 98 */     _sb_.append(")");
/* 99 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\SHomeChartRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */