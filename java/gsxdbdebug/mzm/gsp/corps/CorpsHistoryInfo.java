/*    */ package mzm.gsp.corps;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class CorpsHistoryInfo implements Marshal
/*    */ {
/*    */   public int historyid;
/*    */   public int recordtime;
/*    */   public int historytype;
/*    */   public ArrayList<Octets> parameters;
/*    */   
/*    */   public CorpsHistoryInfo()
/*    */   {
/* 17 */     this.parameters = new ArrayList();
/*    */   }
/*    */   
/*    */   public CorpsHistoryInfo(int _historyid_, int _recordtime_, int _historytype_, ArrayList<Octets> _parameters_) {
/* 21 */     this.historyid = _historyid_;
/* 22 */     this.recordtime = _recordtime_;
/* 23 */     this.historytype = _historytype_;
/* 24 */     this.parameters = _parameters_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 28 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 32 */     _os_.marshal(this.historyid);
/* 33 */     _os_.marshal(this.recordtime);
/* 34 */     _os_.marshal(this.historytype);
/* 35 */     _os_.compact_uint32(this.parameters.size());
/* 36 */     for (Octets _v_ : this.parameters) {
/* 37 */       _os_.marshal(_v_);
/*    */     }
/* 39 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 43 */     this.historyid = _os_.unmarshal_int();
/* 44 */     this.recordtime = _os_.unmarshal_int();
/* 45 */     this.historytype = _os_.unmarshal_int();
/* 46 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 48 */       Octets _v_ = _os_.unmarshal_Octets();
/* 49 */       this.parameters.add(_v_);
/*    */     }
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 55 */     if (_o1_ == this) return true;
/* 56 */     if ((_o1_ instanceof CorpsHistoryInfo)) {
/* 57 */       CorpsHistoryInfo _o_ = (CorpsHistoryInfo)_o1_;
/* 58 */       if (this.historyid != _o_.historyid) return false;
/* 59 */       if (this.recordtime != _o_.recordtime) return false;
/* 60 */       if (this.historytype != _o_.historytype) return false;
/* 61 */       if (!this.parameters.equals(_o_.parameters)) return false;
/* 62 */       return true;
/*    */     }
/* 64 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 68 */     int _h_ = 0;
/* 69 */     _h_ += this.historyid;
/* 70 */     _h_ += this.recordtime;
/* 71 */     _h_ += this.historytype;
/* 72 */     _h_ += this.parameters.hashCode();
/* 73 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 77 */     StringBuilder _sb_ = new StringBuilder();
/* 78 */     _sb_.append("(");
/* 79 */     _sb_.append(this.historyid).append(",");
/* 80 */     _sb_.append(this.recordtime).append(",");
/* 81 */     _sb_.append(this.historytype).append(",");
/* 82 */     _sb_.append(this.parameters).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\CorpsHistoryInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */