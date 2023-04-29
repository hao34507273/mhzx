/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.io.IOException;
/*     */ import ppbio.ByteString;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ 
/*     */ public final class ChatGiftRoleMoney extends XBean implements xbean.ChatGiftRoleMoney
/*     */ {
/*     */   private String rolename;
/*     */   private int moneynum;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.rolename = "";
/*  21 */     this.moneynum = 0;
/*     */   }
/*     */   
/*     */   ChatGiftRoleMoney(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.rolename = "";
/*     */   }
/*     */   
/*     */   public ChatGiftRoleMoney()
/*     */   {
/*  32 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public ChatGiftRoleMoney(ChatGiftRoleMoney _o_)
/*     */   {
/*  37 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   ChatGiftRoleMoney(xbean.ChatGiftRoleMoney _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  42 */     super(_xp_, _vn_);
/*  43 */     if ((_o1_ instanceof ChatGiftRoleMoney)) { assign((ChatGiftRoleMoney)_o1_);
/*  44 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  45 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  46 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(ChatGiftRoleMoney _o_) {
/*  51 */     _o_._xdb_verify_unsafe_();
/*  52 */     this.rolename = _o_.rolename;
/*  53 */     this.moneynum = _o_.moneynum;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  58 */     this.rolename = _o_.rolename;
/*  59 */     this.moneynum = _o_.moneynum;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  65 */     _xdb_verify_unsafe_();
/*  66 */     _os_.marshal(this.rolename, "UTF-16LE");
/*  67 */     _os_.marshal(this.moneynum);
/*  68 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  74 */     _xdb_verify_unsafe_();
/*  75 */     this.rolename = _os_.unmarshal_String("UTF-16LE");
/*  76 */     this.moneynum = _os_.unmarshal_int();
/*  77 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  83 */     _xdb_verify_unsafe_();
/*  84 */     int _size_ = 0;
/*     */     try
/*     */     {
/*  87 */       _size_ += CodedOutputStream.computeBytesSize(1, ByteString.copyFrom(this.rolename, "UTF-16LE"));
/*     */     }
/*     */     catch (java.io.UnsupportedEncodingException e)
/*     */     {
/*  91 */       throw new RuntimeException("UTF-16LE not supported?", e);
/*     */     }
/*  93 */     _size_ += CodedOutputStream.computeInt32Size(2, this.moneynum);
/*  94 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 100 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 103 */       _output_.writeBytes(1, ByteString.copyFrom(this.rolename, "UTF-16LE"));
/* 104 */       _output_.writeInt32(2, this.moneynum);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 108 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 110 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 116 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 119 */       boolean done = false;
/* 120 */       while (!done)
/*     */       {
/* 122 */         int tag = _input_.readTag();
/* 123 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 127 */           done = true;
/* 128 */           break;
/*     */         
/*     */ 
/*     */         case 10: 
/* 132 */           this.rolename = _input_.readBytes().toString("UTF-16LE");
/* 133 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 137 */           this.moneynum = _input_.readInt32();
/* 138 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 142 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 144 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 153 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 157 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 159 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ChatGiftRoleMoney copy()
/*     */   {
/* 165 */     _xdb_verify_unsafe_();
/* 166 */     return new ChatGiftRoleMoney(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ChatGiftRoleMoney toData()
/*     */   {
/* 172 */     _xdb_verify_unsafe_();
/* 173 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.ChatGiftRoleMoney toBean()
/*     */   {
/* 178 */     _xdb_verify_unsafe_();
/* 179 */     return new ChatGiftRoleMoney(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ChatGiftRoleMoney toDataIf()
/*     */   {
/* 185 */     _xdb_verify_unsafe_();
/* 186 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.ChatGiftRoleMoney toBeanIf()
/*     */   {
/* 191 */     _xdb_verify_unsafe_();
/* 192 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 198 */     _xdb_verify_unsafe_();
/* 199 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getRolename()
/*     */   {
/* 206 */     _xdb_verify_unsafe_();
/* 207 */     return this.rolename;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Octets getRolenameOctets()
/*     */   {
/* 214 */     _xdb_verify_unsafe_();
/* 215 */     return Octets.wrap(getRolename(), "UTF-16LE");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getMoneynum()
/*     */   {
/* 222 */     _xdb_verify_unsafe_();
/* 223 */     return this.moneynum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRolename(String _v_)
/*     */   {
/* 230 */     _xdb_verify_unsafe_();
/* 231 */     if (null == _v_)
/* 232 */       throw new NullPointerException();
/* 233 */     xdb.Logs.logIf(new LogKey(this, "rolename")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 237 */         new xdb.logs.LogString(this, ChatGiftRoleMoney.this.rolename)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 241 */             ChatGiftRoleMoney.this.rolename = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 245 */     });
/* 246 */     this.rolename = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRolenameOctets(Octets _v_)
/*     */   {
/* 253 */     _xdb_verify_unsafe_();
/* 254 */     setRolename(_v_.getString("UTF-16LE"));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setMoneynum(int _v_)
/*     */   {
/* 261 */     _xdb_verify_unsafe_();
/* 262 */     xdb.Logs.logIf(new LogKey(this, "moneynum")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 266 */         new xdb.logs.LogInt(this, ChatGiftRoleMoney.this.moneynum)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 270 */             ChatGiftRoleMoney.this.moneynum = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 274 */     });
/* 275 */     this.moneynum = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 281 */     _xdb_verify_unsafe_();
/* 282 */     ChatGiftRoleMoney _o_ = null;
/* 283 */     if ((_o1_ instanceof ChatGiftRoleMoney)) { _o_ = (ChatGiftRoleMoney)_o1_;
/* 284 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 285 */       return false;
/* 286 */     if (!this.rolename.equals(_o_.rolename)) return false;
/* 287 */     if (this.moneynum != _o_.moneynum) return false;
/* 288 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 294 */     _xdb_verify_unsafe_();
/* 295 */     int _h_ = 0;
/* 296 */     _h_ += this.rolename.hashCode();
/* 297 */     _h_ += this.moneynum;
/* 298 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 304 */     _xdb_verify_unsafe_();
/* 305 */     StringBuilder _sb_ = new StringBuilder();
/* 306 */     _sb_.append("(");
/* 307 */     _sb_.append("'").append(this.rolename).append("'");
/* 308 */     _sb_.append(",");
/* 309 */     _sb_.append(this.moneynum);
/* 310 */     _sb_.append(")");
/* 311 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 317 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 318 */     lb.add(new xdb.logs.ListenableChanged().setVarName("rolename"));
/* 319 */     lb.add(new xdb.logs.ListenableChanged().setVarName("moneynum"));
/* 320 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.ChatGiftRoleMoney {
/*     */     private Const() {}
/*     */     
/*     */     ChatGiftRoleMoney nThis() {
/* 327 */       return ChatGiftRoleMoney.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 333 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ChatGiftRoleMoney copy()
/*     */     {
/* 339 */       return ChatGiftRoleMoney.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ChatGiftRoleMoney toData()
/*     */     {
/* 345 */       return ChatGiftRoleMoney.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.ChatGiftRoleMoney toBean()
/*     */     {
/* 350 */       return ChatGiftRoleMoney.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ChatGiftRoleMoney toDataIf()
/*     */     {
/* 356 */       return ChatGiftRoleMoney.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.ChatGiftRoleMoney toBeanIf()
/*     */     {
/* 361 */       return ChatGiftRoleMoney.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public String getRolename()
/*     */     {
/* 368 */       ChatGiftRoleMoney.this._xdb_verify_unsafe_();
/* 369 */       return ChatGiftRoleMoney.this.rolename;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Octets getRolenameOctets()
/*     */     {
/* 376 */       ChatGiftRoleMoney.this._xdb_verify_unsafe_();
/* 377 */       return ChatGiftRoleMoney.this.getRolenameOctets();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getMoneynum()
/*     */     {
/* 384 */       ChatGiftRoleMoney.this._xdb_verify_unsafe_();
/* 385 */       return ChatGiftRoleMoney.this.moneynum;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRolename(String _v_)
/*     */     {
/* 392 */       ChatGiftRoleMoney.this._xdb_verify_unsafe_();
/* 393 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRolenameOctets(Octets _v_)
/*     */     {
/* 400 */       ChatGiftRoleMoney.this._xdb_verify_unsafe_();
/* 401 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setMoneynum(int _v_)
/*     */     {
/* 408 */       ChatGiftRoleMoney.this._xdb_verify_unsafe_();
/* 409 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 415 */       ChatGiftRoleMoney.this._xdb_verify_unsafe_();
/* 416 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 422 */       ChatGiftRoleMoney.this._xdb_verify_unsafe_();
/* 423 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 429 */       return ChatGiftRoleMoney.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 435 */       return ChatGiftRoleMoney.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 441 */       ChatGiftRoleMoney.this._xdb_verify_unsafe_();
/* 442 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 448 */       return ChatGiftRoleMoney.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 454 */       return ChatGiftRoleMoney.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 460 */       ChatGiftRoleMoney.this._xdb_verify_unsafe_();
/* 461 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 467 */       return ChatGiftRoleMoney.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 473 */       return ChatGiftRoleMoney.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 479 */       return ChatGiftRoleMoney.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 485 */       return ChatGiftRoleMoney.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 491 */       return ChatGiftRoleMoney.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 497 */       return ChatGiftRoleMoney.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 503 */       return ChatGiftRoleMoney.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.ChatGiftRoleMoney
/*     */   {
/*     */     private String rolename;
/*     */     
/*     */     private int moneynum;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 517 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 522 */       this.rolename = "";
/*     */     }
/*     */     
/*     */     Data(xbean.ChatGiftRoleMoney _o1_)
/*     */     {
/* 527 */       if ((_o1_ instanceof ChatGiftRoleMoney)) { assign((ChatGiftRoleMoney)_o1_);
/* 528 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 529 */       } else if ((_o1_ instanceof ChatGiftRoleMoney.Const)) assign(((ChatGiftRoleMoney.Const)_o1_).nThis()); else {
/* 530 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(ChatGiftRoleMoney _o_) {
/* 535 */       this.rolename = _o_.rolename;
/* 536 */       this.moneynum = _o_.moneynum;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 541 */       this.rolename = _o_.rolename;
/* 542 */       this.moneynum = _o_.moneynum;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 548 */       _os_.marshal(this.rolename, "UTF-16LE");
/* 549 */       _os_.marshal(this.moneynum);
/* 550 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 556 */       this.rolename = _os_.unmarshal_String("UTF-16LE");
/* 557 */       this.moneynum = _os_.unmarshal_int();
/* 558 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 564 */       int _size_ = 0;
/*     */       try
/*     */       {
/* 567 */         _size_ += CodedOutputStream.computeBytesSize(1, ByteString.copyFrom(this.rolename, "UTF-16LE"));
/*     */       }
/*     */       catch (java.io.UnsupportedEncodingException e)
/*     */       {
/* 571 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*     */       }
/* 573 */       _size_ += CodedOutputStream.computeInt32Size(2, this.moneynum);
/* 574 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 582 */         _output_.writeBytes(1, ByteString.copyFrom(this.rolename, "UTF-16LE"));
/* 583 */         _output_.writeInt32(2, this.moneynum);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 587 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 589 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 597 */         boolean done = false;
/* 598 */         while (!done)
/*     */         {
/* 600 */           int tag = _input_.readTag();
/* 601 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 605 */             done = true;
/* 606 */             break;
/*     */           
/*     */ 
/*     */           case 10: 
/* 610 */             this.rolename = _input_.readBytes().toString("UTF-16LE");
/* 611 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 615 */             this.moneynum = _input_.readInt32();
/* 616 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 620 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 622 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 631 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 635 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 637 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ChatGiftRoleMoney copy()
/*     */     {
/* 643 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ChatGiftRoleMoney toData()
/*     */     {
/* 649 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.ChatGiftRoleMoney toBean()
/*     */     {
/* 654 */       return new ChatGiftRoleMoney(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ChatGiftRoleMoney toDataIf()
/*     */     {
/* 660 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.ChatGiftRoleMoney toBeanIf()
/*     */     {
/* 665 */       return new ChatGiftRoleMoney(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 671 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 675 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 679 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 683 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 687 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 691 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 695 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public String getRolename()
/*     */     {
/* 702 */       return this.rolename;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Octets getRolenameOctets()
/*     */     {
/* 709 */       return Octets.wrap(getRolename(), "UTF-16LE");
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getMoneynum()
/*     */     {
/* 716 */       return this.moneynum;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRolename(String _v_)
/*     */     {
/* 723 */       if (null == _v_)
/* 724 */         throw new NullPointerException();
/* 725 */       this.rolename = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRolenameOctets(Octets _v_)
/*     */     {
/* 732 */       setRolename(_v_.getString("UTF-16LE"));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setMoneynum(int _v_)
/*     */     {
/* 739 */       this.moneynum = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 745 */       if (!(_o1_ instanceof Data)) return false;
/* 746 */       Data _o_ = (Data)_o1_;
/* 747 */       if (!this.rolename.equals(_o_.rolename)) return false;
/* 748 */       if (this.moneynum != _o_.moneynum) return false;
/* 749 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 755 */       int _h_ = 0;
/* 756 */       _h_ += this.rolename.hashCode();
/* 757 */       _h_ += this.moneynum;
/* 758 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 764 */       StringBuilder _sb_ = new StringBuilder();
/* 765 */       _sb_.append("(");
/* 766 */       _sb_.append("'").append(this.rolename).append("'");
/* 767 */       _sb_.append(",");
/* 768 */       _sb_.append(this.moneynum);
/* 769 */       _sb_.append(")");
/* 770 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\ChatGiftRoleMoney.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */