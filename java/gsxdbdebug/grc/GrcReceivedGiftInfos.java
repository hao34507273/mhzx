/*    */ package grc;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.LinkedList;
/*    */ 
/*    */ public class GrcReceivedGiftInfos implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public int gift_type;
/*    */   public long gift_count;
/*    */   public int receive_times;
/*    */   public LinkedList<Long> serialids;
/*    */   
/*    */   public GrcReceivedGiftInfos()
/*    */   {
/* 15 */     this.gift_type = 1;
/* 16 */     this.serialids = new LinkedList();
/*    */   }
/*    */   
/*    */   public GrcReceivedGiftInfos(int _gift_type_, long _gift_count_, int _receive_times_, LinkedList<Long> _serialids_) {
/* 20 */     this.gift_type = _gift_type_;
/* 21 */     this.gift_count = _gift_count_;
/* 22 */     this.receive_times = _receive_times_;
/* 23 */     this.serialids = _serialids_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 27 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 31 */     _os_.marshal(this.gift_type);
/* 32 */     _os_.marshal(this.gift_count);
/* 33 */     _os_.marshal(this.receive_times);
/* 34 */     _os_.compact_uint32(this.serialids.size());
/* 35 */     for (Long _v_ : this.serialids) {
/* 36 */       _os_.marshal(_v_.longValue());
/*    */     }
/* 38 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 42 */     this.gift_type = _os_.unmarshal_int();
/* 43 */     this.gift_count = _os_.unmarshal_long();
/* 44 */     this.receive_times = _os_.unmarshal_int();
/* 45 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 47 */       long _v_ = _os_.unmarshal_long();
/* 48 */       this.serialids.add(Long.valueOf(_v_));
/*    */     }
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 54 */     if (_o1_ == this) return true;
/* 55 */     if ((_o1_ instanceof GrcReceivedGiftInfos)) {
/* 56 */       GrcReceivedGiftInfos _o_ = (GrcReceivedGiftInfos)_o1_;
/* 57 */       if (this.gift_type != _o_.gift_type) return false;
/* 58 */       if (this.gift_count != _o_.gift_count) return false;
/* 59 */       if (this.receive_times != _o_.receive_times) return false;
/* 60 */       if (!this.serialids.equals(_o_.serialids)) return false;
/* 61 */       return true;
/*    */     }
/* 63 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 67 */     int _h_ = 0;
/* 68 */     _h_ += this.gift_type;
/* 69 */     _h_ += (int)this.gift_count;
/* 70 */     _h_ += this.receive_times;
/* 71 */     _h_ += this.serialids.hashCode();
/* 72 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 76 */     StringBuilder _sb_ = new StringBuilder();
/* 77 */     _sb_.append("(");
/* 78 */     _sb_.append(this.gift_type).append(",");
/* 79 */     _sb_.append(this.gift_count).append(",");
/* 80 */     _sb_.append(this.receive_times).append(",");
/* 81 */     _sb_.append(this.serialids).append(",");
/* 82 */     _sb_.append(")");
/* 83 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\grc\GrcReceivedGiftInfos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */