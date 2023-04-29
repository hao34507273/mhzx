/*    */ package hub;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class NotifyCrossCompeteAgainstRsp implements Marshal
/*    */ {
/*    */   public long start_millis;
/*    */   public ArrayList<Integer> compete_list;
/*    */   
/*    */   public NotifyCrossCompeteAgainstRsp()
/*    */   {
/* 15 */     this.compete_list = new ArrayList();
/*    */   }
/*    */   
/*    */   public NotifyCrossCompeteAgainstRsp(long _start_millis_, ArrayList<Integer> _compete_list_) {
/* 19 */     this.start_millis = _start_millis_;
/* 20 */     this.compete_list = _compete_list_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 24 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 28 */     _os_.marshal(this.start_millis);
/* 29 */     _os_.compact_uint32(this.compete_list.size());
/* 30 */     for (Integer _v_ : this.compete_list) {
/* 31 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 33 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 37 */     this.start_millis = _os_.unmarshal_long();
/* 38 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 40 */       int _v_ = _os_.unmarshal_int();
/* 41 */       this.compete_list.add(Integer.valueOf(_v_));
/*    */     }
/* 43 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 47 */     if (_o1_ == this) return true;
/* 48 */     if ((_o1_ instanceof NotifyCrossCompeteAgainstRsp)) {
/* 49 */       NotifyCrossCompeteAgainstRsp _o_ = (NotifyCrossCompeteAgainstRsp)_o1_;
/* 50 */       if (this.start_millis != _o_.start_millis) return false;
/* 51 */       if (!this.compete_list.equals(_o_.compete_list)) return false;
/* 52 */       return true;
/*    */     }
/* 54 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 58 */     int _h_ = 0;
/* 59 */     _h_ += (int)this.start_millis;
/* 60 */     _h_ += this.compete_list.hashCode();
/* 61 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 65 */     StringBuilder _sb_ = new StringBuilder();
/* 66 */     _sb_.append("(");
/* 67 */     _sb_.append(this.start_millis).append(",");
/* 68 */     _sb_.append(this.compete_list).append(",");
/* 69 */     _sb_.append(")");
/* 70 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\NotifyCrossCompeteAgainstRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */