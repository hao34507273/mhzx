/*    */ package mzm.gsp.menpaipvp;
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
/*    */ public class SChartRes
/*    */   extends __SChartRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12596229;
/*    */   public int menpai;
/*    */   public int page;
/*    */   public ArrayList<Score> data_list;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12596229;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SChartRes()
/*    */   {
/* 33 */     this.data_list = new ArrayList();
/*    */   }
/*    */   
/*    */   public SChartRes(int _menpai_, int _page_, ArrayList<Score> _data_list_) {
/* 37 */     this.menpai = _menpai_;
/* 38 */     this.page = _page_;
/* 39 */     this.data_list = _data_list_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     for (Score _v_ : this.data_list)
/* 44 */       if (!_v_._validator_()) return false;
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.menpai);
/* 50 */     _os_.marshal(this.page);
/* 51 */     _os_.compact_uint32(this.data_list.size());
/* 52 */     for (Score _v_ : this.data_list) {
/* 53 */       _os_.marshal(_v_);
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 59 */     this.menpai = _os_.unmarshal_int();
/* 60 */     this.page = _os_.unmarshal_int();
/* 61 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 62 */       Score _v_ = new Score();
/* 63 */       _v_.unmarshal(_os_);
/* 64 */       this.data_list.add(_v_);
/*    */     }
/* 66 */     if (!_validator_()) {
/* 67 */       throw new VerifyError("validator failed");
/*    */     }
/* 69 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 73 */     if (_o1_ == this) return true;
/* 74 */     if ((_o1_ instanceof SChartRes)) {
/* 75 */       SChartRes _o_ = (SChartRes)_o1_;
/* 76 */       if (this.menpai != _o_.menpai) return false;
/* 77 */       if (this.page != _o_.page) return false;
/* 78 */       if (!this.data_list.equals(_o_.data_list)) return false;
/* 79 */       return true;
/*    */     }
/* 81 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 85 */     int _h_ = 0;
/* 86 */     _h_ += this.menpai;
/* 87 */     _h_ += this.page;
/* 88 */     _h_ += this.data_list.hashCode();
/* 89 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 93 */     StringBuilder _sb_ = new StringBuilder();
/* 94 */     _sb_.append("(");
/* 95 */     _sb_.append(this.menpai).append(",");
/* 96 */     _sb_.append(this.page).append(",");
/* 97 */     _sb_.append(this.data_list).append(",");
/* 98 */     _sb_.append(")");
/* 99 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaipvp\SChartRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */