/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.Bean;
/*     */ import xdb.XBean;
/*     */ 
/*     */ public final class FightCommand extends XBean implements xbean.FightCommand
/*     */ {
/*     */   private ArrayList<xbean.FightCommandInfo> commandfriendlist;
/*     */   private ArrayList<xbean.FightCommandInfo> commandenermylist;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.commandfriendlist.clear();
/*  21 */     this.commandenermylist.clear();
/*     */   }
/*     */   
/*     */   FightCommand(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.commandfriendlist = new ArrayList();
/*  28 */     this.commandenermylist = new ArrayList();
/*     */   }
/*     */   
/*     */   public FightCommand()
/*     */   {
/*  33 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public FightCommand(FightCommand _o_)
/*     */   {
/*  38 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   FightCommand(xbean.FightCommand _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  43 */     super(_xp_, _vn_);
/*  44 */     if ((_o1_ instanceof FightCommand)) { assign((FightCommand)_o1_);
/*  45 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  46 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  47 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(FightCommand _o_) {
/*  52 */     _o_._xdb_verify_unsafe_();
/*  53 */     this.commandfriendlist = new ArrayList();
/*  54 */     for (xbean.FightCommandInfo _v_ : _o_.commandfriendlist)
/*  55 */       this.commandfriendlist.add(new FightCommandInfo(_v_, this, "commandfriendlist"));
/*  56 */     this.commandenermylist = new ArrayList();
/*  57 */     for (xbean.FightCommandInfo _v_ : _o_.commandenermylist) {
/*  58 */       this.commandenermylist.add(new FightCommandInfo(_v_, this, "commandenermylist"));
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(Data _o_) {
/*  63 */     this.commandfriendlist = new ArrayList();
/*  64 */     for (xbean.FightCommandInfo _v_ : _o_.commandfriendlist)
/*  65 */       this.commandfriendlist.add(new FightCommandInfo(_v_, this, "commandfriendlist"));
/*  66 */     this.commandenermylist = new ArrayList();
/*  67 */     for (xbean.FightCommandInfo _v_ : _o_.commandenermylist) {
/*  68 */       this.commandenermylist.add(new FightCommandInfo(_v_, this, "commandenermylist"));
/*     */     }
/*     */   }
/*     */   
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  74 */     _xdb_verify_unsafe_();
/*  75 */     _os_.compact_uint32(this.commandfriendlist.size());
/*  76 */     for (xbean.FightCommandInfo _v_ : this.commandfriendlist)
/*     */     {
/*  78 */       _v_.marshal(_os_);
/*     */     }
/*  80 */     _os_.compact_uint32(this.commandenermylist.size());
/*  81 */     for (xbean.FightCommandInfo _v_ : this.commandenermylist)
/*     */     {
/*  83 */       _v_.marshal(_os_);
/*     */     }
/*  85 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  91 */     _xdb_verify_unsafe_();
/*  92 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  94 */       xbean.FightCommandInfo _v_ = new FightCommandInfo(0, this, "commandfriendlist");
/*  95 */       _v_.unmarshal(_os_);
/*  96 */       this.commandfriendlist.add(_v_);
/*     */     }
/*  98 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/* 100 */       xbean.FightCommandInfo _v_ = new FightCommandInfo(0, this, "commandenermylist");
/* 101 */       _v_.unmarshal(_os_);
/* 102 */       this.commandenermylist.add(_v_);
/*     */     }
/* 104 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 110 */     _xdb_verify_unsafe_();
/* 111 */     int _size_ = 0;
/* 112 */     for (xbean.FightCommandInfo _v_ : this.commandfriendlist)
/*     */     {
/* 114 */       _size_ += CodedOutputStream.computeMessageSize(1, _v_);
/*     */     }
/* 116 */     for (xbean.FightCommandInfo _v_ : this.commandenermylist)
/*     */     {
/* 118 */       _size_ += CodedOutputStream.computeMessageSize(2, _v_);
/*     */     }
/* 120 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 126 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 129 */       for (xbean.FightCommandInfo _v_ : this.commandfriendlist)
/*     */       {
/* 131 */         _output_.writeMessage(1, _v_);
/*     */       }
/* 133 */       for (xbean.FightCommandInfo _v_ : this.commandenermylist)
/*     */       {
/* 135 */         _output_.writeMessage(2, _v_);
/*     */       }
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 140 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 142 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 148 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 151 */       boolean done = false;
/* 152 */       while (!done)
/*     */       {
/* 154 */         int tag = _input_.readTag();
/* 155 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 159 */           done = true;
/* 160 */           break;
/*     */         
/*     */ 
/*     */         case 10: 
/* 164 */           xbean.FightCommandInfo _v_ = new FightCommandInfo(0, this, "commandfriendlist");
/* 165 */           _input_.readMessage(_v_);
/* 166 */           this.commandfriendlist.add(_v_);
/* 167 */           break;
/*     */         
/*     */ 
/*     */         case 18: 
/* 171 */           xbean.FightCommandInfo _v_ = new FightCommandInfo(0, this, "commandenermylist");
/* 172 */           _input_.readMessage(_v_);
/* 173 */           this.commandenermylist.add(_v_);
/* 174 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 178 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 180 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 189 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 193 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 195 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.FightCommand copy()
/*     */   {
/* 201 */     _xdb_verify_unsafe_();
/* 202 */     return new FightCommand(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.FightCommand toData()
/*     */   {
/* 208 */     _xdb_verify_unsafe_();
/* 209 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.FightCommand toBean()
/*     */   {
/* 214 */     _xdb_verify_unsafe_();
/* 215 */     return new FightCommand(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.FightCommand toDataIf()
/*     */   {
/* 221 */     _xdb_verify_unsafe_();
/* 222 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.FightCommand toBeanIf()
/*     */   {
/* 227 */     _xdb_verify_unsafe_();
/* 228 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public Bean toConst()
/*     */   {
/* 234 */     _xdb_verify_unsafe_();
/* 235 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<xbean.FightCommandInfo> getCommandfriendlist()
/*     */   {
/* 242 */     _xdb_verify_unsafe_();
/* 243 */     return xdb.Logs.logList(new xdb.LogKey(this, "commandfriendlist"), this.commandfriendlist);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<xbean.FightCommandInfo> getCommandfriendlistAsData()
/*     */   {
/* 249 */     _xdb_verify_unsafe_();
/*     */     
/* 251 */     FightCommand _o_ = this;
/* 252 */     List<xbean.FightCommandInfo> commandfriendlist = new ArrayList();
/* 253 */     for (xbean.FightCommandInfo _v_ : _o_.commandfriendlist)
/* 254 */       commandfriendlist.add(new FightCommandInfo.Data(_v_));
/* 255 */     return commandfriendlist;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<xbean.FightCommandInfo> getCommandenermylist()
/*     */   {
/* 262 */     _xdb_verify_unsafe_();
/* 263 */     return xdb.Logs.logList(new xdb.LogKey(this, "commandenermylist"), this.commandenermylist);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<xbean.FightCommandInfo> getCommandenermylistAsData()
/*     */   {
/* 269 */     _xdb_verify_unsafe_();
/*     */     
/* 271 */     FightCommand _o_ = this;
/* 272 */     List<xbean.FightCommandInfo> commandenermylist = new ArrayList();
/* 273 */     for (xbean.FightCommandInfo _v_ : _o_.commandenermylist)
/* 274 */       commandenermylist.add(new FightCommandInfo.Data(_v_));
/* 275 */     return commandenermylist;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 281 */     _xdb_verify_unsafe_();
/* 282 */     FightCommand _o_ = null;
/* 283 */     if ((_o1_ instanceof FightCommand)) { _o_ = (FightCommand)_o1_;
/* 284 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 285 */       return false;
/* 286 */     if (!this.commandfriendlist.equals(_o_.commandfriendlist)) return false;
/* 287 */     if (!this.commandenermylist.equals(_o_.commandenermylist)) return false;
/* 288 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 294 */     _xdb_verify_unsafe_();
/* 295 */     int _h_ = 0;
/* 296 */     _h_ += this.commandfriendlist.hashCode();
/* 297 */     _h_ += this.commandenermylist.hashCode();
/* 298 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 304 */     _xdb_verify_unsafe_();
/* 305 */     StringBuilder _sb_ = new StringBuilder();
/* 306 */     _sb_.append("(");
/* 307 */     _sb_.append(this.commandfriendlist);
/* 308 */     _sb_.append(",");
/* 309 */     _sb_.append(this.commandenermylist);
/* 310 */     _sb_.append(")");
/* 311 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 317 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 318 */     lb.add(new xdb.logs.ListenableChanged().setVarName("commandfriendlist"));
/* 319 */     lb.add(new xdb.logs.ListenableChanged().setVarName("commandenermylist"));
/* 320 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.FightCommand {
/*     */     private Const() {}
/*     */     
/*     */     FightCommand nThis() {
/* 327 */       return FightCommand.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 333 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FightCommand copy()
/*     */     {
/* 339 */       return FightCommand.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FightCommand toData()
/*     */     {
/* 345 */       return FightCommand.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.FightCommand toBean()
/*     */     {
/* 350 */       return FightCommand.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FightCommand toDataIf()
/*     */     {
/* 356 */       return FightCommand.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.FightCommand toBeanIf()
/*     */     {
/* 361 */       return FightCommand.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<xbean.FightCommandInfo> getCommandfriendlist()
/*     */     {
/* 368 */       FightCommand.this._xdb_verify_unsafe_();
/* 369 */       return xdb.Consts.constList(FightCommand.this.commandfriendlist);
/*     */     }
/*     */     
/*     */ 
/*     */     public List<xbean.FightCommandInfo> getCommandfriendlistAsData()
/*     */     {
/* 375 */       FightCommand.this._xdb_verify_unsafe_();
/*     */       
/* 377 */       FightCommand _o_ = FightCommand.this;
/* 378 */       List<xbean.FightCommandInfo> commandfriendlist = new ArrayList();
/* 379 */       for (xbean.FightCommandInfo _v_ : _o_.commandfriendlist)
/* 380 */         commandfriendlist.add(new FightCommandInfo.Data(_v_));
/* 381 */       return commandfriendlist;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<xbean.FightCommandInfo> getCommandenermylist()
/*     */     {
/* 388 */       FightCommand.this._xdb_verify_unsafe_();
/* 389 */       return xdb.Consts.constList(FightCommand.this.commandenermylist);
/*     */     }
/*     */     
/*     */ 
/*     */     public List<xbean.FightCommandInfo> getCommandenermylistAsData()
/*     */     {
/* 395 */       FightCommand.this._xdb_verify_unsafe_();
/*     */       
/* 397 */       FightCommand _o_ = FightCommand.this;
/* 398 */       List<xbean.FightCommandInfo> commandenermylist = new ArrayList();
/* 399 */       for (xbean.FightCommandInfo _v_ : _o_.commandenermylist)
/* 400 */         commandenermylist.add(new FightCommandInfo.Data(_v_));
/* 401 */       return commandenermylist;
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 407 */       FightCommand.this._xdb_verify_unsafe_();
/* 408 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 414 */       FightCommand.this._xdb_verify_unsafe_();
/* 415 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 421 */       return FightCommand.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 427 */       return FightCommand.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 433 */       FightCommand.this._xdb_verify_unsafe_();
/* 434 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 440 */       return FightCommand.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 446 */       return FightCommand.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 452 */       FightCommand.this._xdb_verify_unsafe_();
/* 453 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 459 */       return FightCommand.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 465 */       return FightCommand.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 471 */       return FightCommand.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 477 */       return FightCommand.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 483 */       return FightCommand.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 489 */       return FightCommand.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 495 */       return FightCommand.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.FightCommand
/*     */   {
/*     */     private ArrayList<xbean.FightCommandInfo> commandfriendlist;
/*     */     
/*     */     private ArrayList<xbean.FightCommandInfo> commandenermylist;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 509 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 514 */       this.commandfriendlist = new ArrayList();
/* 515 */       this.commandenermylist = new ArrayList();
/*     */     }
/*     */     
/*     */     Data(xbean.FightCommand _o1_)
/*     */     {
/* 520 */       if ((_o1_ instanceof FightCommand)) { assign((FightCommand)_o1_);
/* 521 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 522 */       } else if ((_o1_ instanceof FightCommand.Const)) assign(((FightCommand.Const)_o1_).nThis()); else {
/* 523 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(FightCommand _o_) {
/* 528 */       this.commandfriendlist = new ArrayList();
/* 529 */       for (xbean.FightCommandInfo _v_ : _o_.commandfriendlist)
/* 530 */         this.commandfriendlist.add(new FightCommandInfo.Data(_v_));
/* 531 */       this.commandenermylist = new ArrayList();
/* 532 */       for (xbean.FightCommandInfo _v_ : _o_.commandenermylist) {
/* 533 */         this.commandenermylist.add(new FightCommandInfo.Data(_v_));
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(Data _o_) {
/* 538 */       this.commandfriendlist = new ArrayList();
/* 539 */       for (xbean.FightCommandInfo _v_ : _o_.commandfriendlist)
/* 540 */         this.commandfriendlist.add(new FightCommandInfo.Data(_v_));
/* 541 */       this.commandenermylist = new ArrayList();
/* 542 */       for (xbean.FightCommandInfo _v_ : _o_.commandenermylist) {
/* 543 */         this.commandenermylist.add(new FightCommandInfo.Data(_v_));
/*     */       }
/*     */     }
/*     */     
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 549 */       _os_.compact_uint32(this.commandfriendlist.size());
/* 550 */       for (xbean.FightCommandInfo _v_ : this.commandfriendlist)
/*     */       {
/* 552 */         _v_.marshal(_os_);
/*     */       }
/* 554 */       _os_.compact_uint32(this.commandenermylist.size());
/* 555 */       for (xbean.FightCommandInfo _v_ : this.commandenermylist)
/*     */       {
/* 557 */         _v_.marshal(_os_);
/*     */       }
/* 559 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 565 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 567 */         xbean.FightCommandInfo _v_ = xbean.Pod.newFightCommandInfoData();
/* 568 */         _v_.unmarshal(_os_);
/* 569 */         this.commandfriendlist.add(_v_);
/*     */       }
/* 571 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 573 */         xbean.FightCommandInfo _v_ = xbean.Pod.newFightCommandInfoData();
/* 574 */         _v_.unmarshal(_os_);
/* 575 */         this.commandenermylist.add(_v_);
/*     */       }
/* 577 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 583 */       int _size_ = 0;
/* 584 */       for (xbean.FightCommandInfo _v_ : this.commandfriendlist)
/*     */       {
/* 586 */         _size_ += CodedOutputStream.computeMessageSize(1, _v_);
/*     */       }
/* 588 */       for (xbean.FightCommandInfo _v_ : this.commandenermylist)
/*     */       {
/* 590 */         _size_ += CodedOutputStream.computeMessageSize(2, _v_);
/*     */       }
/* 592 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 600 */         for (xbean.FightCommandInfo _v_ : this.commandfriendlist)
/*     */         {
/* 602 */           _output_.writeMessage(1, _v_);
/*     */         }
/* 604 */         for (xbean.FightCommandInfo _v_ : this.commandenermylist)
/*     */         {
/* 606 */           _output_.writeMessage(2, _v_);
/*     */         }
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 611 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 613 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 621 */         boolean done = false;
/* 622 */         while (!done)
/*     */         {
/* 624 */           int tag = _input_.readTag();
/* 625 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 629 */             done = true;
/* 630 */             break;
/*     */           
/*     */ 
/*     */           case 10: 
/* 634 */             xbean.FightCommandInfo _v_ = xbean.Pod.newFightCommandInfoData();
/* 635 */             _input_.readMessage(_v_);
/* 636 */             this.commandfriendlist.add(_v_);
/* 637 */             break;
/*     */           
/*     */ 
/*     */           case 18: 
/* 641 */             xbean.FightCommandInfo _v_ = xbean.Pod.newFightCommandInfoData();
/* 642 */             _input_.readMessage(_v_);
/* 643 */             this.commandenermylist.add(_v_);
/* 644 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 648 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 650 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 659 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 663 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 665 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FightCommand copy()
/*     */     {
/* 671 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FightCommand toData()
/*     */     {
/* 677 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.FightCommand toBean()
/*     */     {
/* 682 */       return new FightCommand(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FightCommand toDataIf()
/*     */     {
/* 688 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.FightCommand toBeanIf()
/*     */     {
/* 693 */       return new FightCommand(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 699 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent() {
/* 703 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 707 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 711 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean toConst() {
/* 715 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 719 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 723 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<xbean.FightCommandInfo> getCommandfriendlist()
/*     */     {
/* 730 */       return this.commandfriendlist;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<xbean.FightCommandInfo> getCommandfriendlistAsData()
/*     */     {
/* 737 */       return this.commandfriendlist;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<xbean.FightCommandInfo> getCommandenermylist()
/*     */     {
/* 744 */       return this.commandenermylist;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<xbean.FightCommandInfo> getCommandenermylistAsData()
/*     */     {
/* 751 */       return this.commandenermylist;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 757 */       if (!(_o1_ instanceof Data)) return false;
/* 758 */       Data _o_ = (Data)_o1_;
/* 759 */       if (!this.commandfriendlist.equals(_o_.commandfriendlist)) return false;
/* 760 */       if (!this.commandenermylist.equals(_o_.commandenermylist)) return false;
/* 761 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 767 */       int _h_ = 0;
/* 768 */       _h_ += this.commandfriendlist.hashCode();
/* 769 */       _h_ += this.commandenermylist.hashCode();
/* 770 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 776 */       StringBuilder _sb_ = new StringBuilder();
/* 777 */       _sb_.append("(");
/* 778 */       _sb_.append(this.commandfriendlist);
/* 779 */       _sb_.append(",");
/* 780 */       _sb_.append(this.commandenermylist);
/* 781 */       _sb_.append(")");
/* 782 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\FightCommand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */