/*    */ package mzm.gsp.chart;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.pubdata.ModelInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class STopModelListRes
/*    */   extends __STopModelListRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12587795;
/*    */   public ArrayList<ModelInfo> datalist;
/*    */   public int charttype;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12587795;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public STopModelListRes()
/*    */   {
/* 34 */     this.datalist = new ArrayList();
/*    */   }
/*    */   
/*    */   public STopModelListRes(ArrayList<ModelInfo> _datalist_, int _charttype_) {
/* 38 */     this.datalist = _datalist_;
/* 39 */     this.charttype = _charttype_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     for (ModelInfo _v_ : this.datalist)
/* 44 */       if (!_v_._validator_()) return false;
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.compact_uint32(this.datalist.size());
/* 50 */     for (ModelInfo _v_ : this.datalist) {
/* 51 */       _os_.marshal(_v_);
/*    */     }
/* 53 */     _os_.marshal(this.charttype);
/* 54 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 58 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 59 */       ModelInfo _v_ = new ModelInfo();
/* 60 */       _v_.unmarshal(_os_);
/* 61 */       this.datalist.add(_v_);
/*    */     }
/* 63 */     this.charttype = _os_.unmarshal_int();
/* 64 */     if (!_validator_()) {
/* 65 */       throw new VerifyError("validator failed");
/*    */     }
/* 67 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 71 */     if (_o1_ == this) return true;
/* 72 */     if ((_o1_ instanceof STopModelListRes)) {
/* 73 */       STopModelListRes _o_ = (STopModelListRes)_o1_;
/* 74 */       if (!this.datalist.equals(_o_.datalist)) return false;
/* 75 */       if (this.charttype != _o_.charttype) return false;
/* 76 */       return true;
/*    */     }
/* 78 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 82 */     int _h_ = 0;
/* 83 */     _h_ += this.datalist.hashCode();
/* 84 */     _h_ += this.charttype;
/* 85 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 89 */     StringBuilder _sb_ = new StringBuilder();
/* 90 */     _sb_.append("(");
/* 91 */     _sb_.append(this.datalist).append(",");
/* 92 */     _sb_.append(this.charttype).append(",");
/* 93 */     _sb_.append(")");
/* 94 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chart\STopModelListRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */