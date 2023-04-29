/*     */ package xbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import ppbio.Message;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CombiningGangsKey
/*     */   implements Marshal, Message, Comparable<CombiningGangsKey>
/*     */ {
/*     */   private long front;
/*     */   private long behind;
/*     */   
/*     */   public CombiningGangsKey() {}
/*     */   
/*     */   public CombiningGangsKey(long front, long behind)
/*     */   {
/*  26 */     this.front = front;
/*  27 */     this.behind = behind;
/*     */   }
/*     */   
/*     */ 
/*     */   public long getFront()
/*     */   {
/*  33 */     return this.front;
/*     */   }
/*     */   
/*     */ 
/*     */   public long getBehind()
/*     */   {
/*  39 */     return this.behind;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  45 */     _os_.marshal(this.front);
/*  46 */     _os_.marshal(this.behind);
/*  47 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws MarshalException
/*     */   {
/*  53 */     this.front = _os_.unmarshal_long();
/*  54 */     this.behind = _os_.unmarshal_long();
/*  55 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int getSerializedSize()
/*     */   {
/*  61 */     int _size_ = 0;
/*  62 */     _size_ += CodedOutputStream.computeInt64Size(1, this.front);
/*  63 */     _size_ += CodedOutputStream.computeInt64Size(2, this.behind);
/*  64 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/*     */     try
/*     */     {
/*  72 */       _output_.writeInt64(1, this.front);
/*  73 */       _output_.writeInt64(2, this.behind);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/*  77 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/*  79 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/*     */     try
/*     */     {
/*  87 */       boolean done = false;
/*  88 */       while (!done)
/*     */       {
/*  90 */         int tag = _input_.readTag();
/*  91 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/*  95 */           done = true;
/*  96 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 100 */           this.front = _input_.readInt64();
/* 101 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 105 */           this.behind = _input_.readInt64();
/* 106 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 110 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 112 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 121 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 125 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 127 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int compareTo(CombiningGangsKey _o_)
/*     */   {
/* 133 */     if (_o_ == this)
/* 134 */       return 0;
/* 135 */     int _c_ = 0;
/* 136 */     _c_ = Long.signum(this.front - _o_.front);
/* 137 */     if (0 != _c_) return _c_;
/* 138 */     _c_ = Long.signum(this.behind - _o_.behind);
/* 139 */     if (0 != _c_) return _c_;
/* 140 */     return _c_;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean equals(Object _o_)
/*     */   {
/* 146 */     if ((_o_ instanceof CombiningGangsKey))
/* 147 */       return 0 == compareTo((CombiningGangsKey)_o_);
/* 148 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   public int hashCode()
/*     */   {
/* 154 */     int _h_ = 0;
/* 155 */     _h_ = (int)(_h_ + this.front);
/* 156 */     _h_ = (int)(_h_ + this.behind);
/* 157 */     return _h_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\CombiningGangsKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */