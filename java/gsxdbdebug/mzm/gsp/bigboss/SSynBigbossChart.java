/*    */ package mzm.gsp.bigboss;
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
/*    */ public class SSynBigbossChart
/*    */   extends __SSynBigbossChart__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12598025;
/*    */   public int ocp;
/*    */   public int page;
/*    */   public ArrayList<BigbossRankData> ranklist;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12598025;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SSynBigbossChart()
/*    */   {
/* 33 */     this.ranklist = new ArrayList();
/*    */   }
/*    */   
/*    */   public SSynBigbossChart(int _ocp_, int _page_, ArrayList<BigbossRankData> _ranklist_) {
/* 37 */     this.ocp = _ocp_;
/* 38 */     this.page = _page_;
/* 39 */     this.ranklist = _ranklist_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     for (BigbossRankData _v_ : this.ranklist)
/* 44 */       if (!_v_._validator_()) return false;
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.ocp);
/* 50 */     _os_.marshal(this.page);
/* 51 */     _os_.compact_uint32(this.ranklist.size());
/* 52 */     for (BigbossRankData _v_ : this.ranklist) {
/* 53 */       _os_.marshal(_v_);
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 59 */     this.ocp = _os_.unmarshal_int();
/* 60 */     this.page = _os_.unmarshal_int();
/* 61 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 62 */       BigbossRankData _v_ = new BigbossRankData();
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
/* 74 */     if ((_o1_ instanceof SSynBigbossChart)) {
/* 75 */       SSynBigbossChart _o_ = (SSynBigbossChart)_o1_;
/* 76 */       if (this.ocp != _o_.ocp) return false;
/* 77 */       if (this.page != _o_.page) return false;
/* 78 */       if (!this.ranklist.equals(_o_.ranklist)) return false;
/* 79 */       return true;
/*    */     }
/* 81 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 85 */     int _h_ = 0;
/* 86 */     _h_ += this.ocp;
/* 87 */     _h_ += this.page;
/* 88 */     _h_ += this.ranklist.hashCode();
/* 89 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 93 */     StringBuilder _sb_ = new StringBuilder();
/* 94 */     _sb_.append("(");
/* 95 */     _sb_.append(this.ocp).append(",");
/* 96 */     _sb_.append(this.page).append(",");
/* 97 */     _sb_.append(this.ranklist).append(",");
/* 98 */     _sb_.append(")");
/* 99 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bigboss\SSynBigbossChart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */