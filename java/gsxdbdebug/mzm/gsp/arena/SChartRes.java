/*    */ package mzm.gsp.arena;
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
/*    */ public class SChartRes
/*    */   extends __SChartRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12596744;
/*    */   public int page;
/*    */   public ArrayList<Score> data_list;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12596744;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SChartRes()
/*    */   {
/* 32 */     this.data_list = new ArrayList();
/*    */   }
/*    */   
/*    */   public SChartRes(int _page_, ArrayList<Score> _data_list_) {
/* 36 */     this.page = _page_;
/* 37 */     this.data_list = _data_list_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     for (Score _v_ : this.data_list)
/* 42 */       if (!_v_._validator_()) return false;
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.marshal(this.page);
/* 48 */     _os_.compact_uint32(this.data_list.size());
/* 49 */     for (Score _v_ : this.data_list) {
/* 50 */       _os_.marshal(_v_);
/*    */     }
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.page = _os_.unmarshal_int();
/* 57 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 58 */       Score _v_ = new Score();
/* 59 */       _v_.unmarshal(_os_);
/* 60 */       this.data_list.add(_v_);
/*    */     }
/* 62 */     if (!_validator_()) {
/* 63 */       throw new VerifyError("validator failed");
/*    */     }
/* 65 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 69 */     if (_o1_ == this) return true;
/* 70 */     if ((_o1_ instanceof SChartRes)) {
/* 71 */       SChartRes _o_ = (SChartRes)_o1_;
/* 72 */       if (this.page != _o_.page) return false;
/* 73 */       if (!this.data_list.equals(_o_.data_list)) return false;
/* 74 */       return true;
/*    */     }
/* 76 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 80 */     int _h_ = 0;
/* 81 */     _h_ += this.page;
/* 82 */     _h_ += this.data_list.hashCode();
/* 83 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 87 */     StringBuilder _sb_ = new StringBuilder();
/* 88 */     _sb_.append("(");
/* 89 */     _sb_.append(this.page).append(",");
/* 90 */     _sb_.append(this.data_list).append(",");
/* 91 */     _sb_.append(")");
/* 92 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\arena\SChartRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */