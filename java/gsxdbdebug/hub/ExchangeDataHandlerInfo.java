/*    */ package hub;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class ExchangeDataHandlerInfo implements Marshal
/*    */ {
/*    */   public long sn;
/*    */   public ArrayList<Octets> data_list;
/*    */   
/*    */   public ExchangeDataHandlerInfo()
/*    */   {
/* 15 */     this.sn = 0L;
/* 16 */     this.data_list = new ArrayList();
/*    */   }
/*    */   
/*    */   public ExchangeDataHandlerInfo(long _sn_, ArrayList<Octets> _data_list_) {
/* 20 */     this.sn = _sn_;
/* 21 */     this.data_list = _data_list_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 25 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 29 */     _os_.marshal(this.sn);
/* 30 */     _os_.compact_uint32(this.data_list.size());
/* 31 */     for (Octets _v_ : this.data_list) {
/* 32 */       _os_.marshal(_v_);
/*    */     }
/* 34 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 38 */     this.sn = _os_.unmarshal_long();
/* 39 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 41 */       Octets _v_ = _os_.unmarshal_Octets();
/* 42 */       this.data_list.add(_v_);
/*    */     }
/* 44 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 48 */     if (_o1_ == this) return true;
/* 49 */     if ((_o1_ instanceof ExchangeDataHandlerInfo)) {
/* 50 */       ExchangeDataHandlerInfo _o_ = (ExchangeDataHandlerInfo)_o1_;
/* 51 */       if (this.sn != _o_.sn) return false;
/* 52 */       if (!this.data_list.equals(_o_.data_list)) return false;
/* 53 */       return true;
/*    */     }
/* 55 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 59 */     int _h_ = 0;
/* 60 */     _h_ += (int)this.sn;
/* 61 */     _h_ += this.data_list.hashCode();
/* 62 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 66 */     StringBuilder _sb_ = new StringBuilder();
/* 67 */     _sb_.append("(");
/* 68 */     _sb_.append(this.sn).append(",");
/* 69 */     _sb_.append(this.data_list).append(",");
/* 70 */     _sb_.append(")");
/* 71 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\ExchangeDataHandlerInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */