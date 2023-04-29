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
/*     */ public class MatchKey
/*     */   implements Marshal, Message, Comparable<MatchKey>
/*     */ {
/*     */   private int activityid;
/*     */   private int index;
/*     */   
/*     */   public MatchKey() {}
/*     */   
/*     */   public MatchKey(int activityid, int index)
/*     */   {
/*  26 */     this.activityid = activityid;
/*  27 */     this.index = index;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getActivityid()
/*     */   {
/*  33 */     return this.activityid;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getIndex()
/*     */   {
/*  39 */     return this.index;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  45 */     _os_.marshal(this.activityid);
/*  46 */     _os_.marshal(this.index);
/*  47 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws MarshalException
/*     */   {
/*  53 */     this.activityid = _os_.unmarshal_int();
/*  54 */     this.index = _os_.unmarshal_int();
/*  55 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int getSerializedSize()
/*     */   {
/*  61 */     int _size_ = 0;
/*  62 */     _size_ += CodedOutputStream.computeInt32Size(1, this.activityid);
/*  63 */     _size_ += CodedOutputStream.computeInt32Size(2, this.index);
/*  64 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/*     */     try
/*     */     {
/*  72 */       _output_.writeInt32(1, this.activityid);
/*  73 */       _output_.writeInt32(2, this.index);
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
/* 100 */           this.activityid = _input_.readInt32();
/* 101 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 105 */           this.index = _input_.readInt32();
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
/*     */   public int compareTo(MatchKey _o_)
/*     */   {
/* 133 */     if (_o_ == this)
/* 134 */       return 0;
/* 135 */     int _c_ = 0;
/* 136 */     _c_ = Integer.signum(this.activityid - _o_.activityid);
/* 137 */     if (0 != _c_) return _c_;
/* 138 */     _c_ = Integer.signum(this.index - _o_.index);
/* 139 */     if (0 != _c_) return _c_;
/* 140 */     return _c_;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean equals(Object _o_)
/*     */   {
/* 146 */     if ((_o_ instanceof MatchKey))
/* 147 */       return 0 == compareTo((MatchKey)_o_);
/* 148 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   public int hashCode()
/*     */   {
/* 154 */     int _h_ = 0;
/* 155 */     _h_ += this.activityid;
/* 156 */     _h_ += this.index;
/* 157 */     return _h_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\MatchKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */