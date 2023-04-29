/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import com.goldhuman.Common.Octets;
/*      */ import java.io.IOException;
/*      */ import ppbio.ByteString;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.Bean;
/*      */ import xdb.Log;
/*      */ import xdb.LogKey;
/*      */ import xdb.Logs;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.LogInt;
/*      */ import xdb.logs.LogLong;
/*      */ 
/*      */ public final class CheckOrderInfo extends XBean implements xbean.CheckOrderInfo
/*      */ {
/*      */   private int status;
/*      */   private int flags;
/*      */   private String userid;
/*      */   private int cost;
/*      */   private int cost_bind;
/*      */   private int present;
/*      */   private int present_bind;
/*      */   private long create_time;
/*      */   private long confirm_success_time;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   34 */     this.status = 0;
/*   35 */     this.flags = 0;
/*   36 */     this.userid = "";
/*   37 */     this.cost = 0;
/*   38 */     this.cost_bind = 0;
/*   39 */     this.present = 0;
/*   40 */     this.present_bind = 0;
/*   41 */     this.create_time = 0L;
/*   42 */     this.confirm_success_time = 0L;
/*      */   }
/*      */   
/*      */   CheckOrderInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   47 */     super(_xp_, _vn_);
/*   48 */     this.userid = "";
/*   49 */     this.cost = 0;
/*   50 */     this.cost_bind = 0;
/*   51 */     this.present = 0;
/*   52 */     this.present_bind = 0;
/*   53 */     this.create_time = 0L;
/*   54 */     this.confirm_success_time = 0L;
/*      */   }
/*      */   
/*      */   public CheckOrderInfo()
/*      */   {
/*   59 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public CheckOrderInfo(CheckOrderInfo _o_)
/*      */   {
/*   64 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   CheckOrderInfo(xbean.CheckOrderInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   69 */     super(_xp_, _vn_);
/*   70 */     if ((_o1_ instanceof CheckOrderInfo)) { assign((CheckOrderInfo)_o1_);
/*   71 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   72 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   73 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(CheckOrderInfo _o_) {
/*   78 */     _o_._xdb_verify_unsafe_();
/*   79 */     this.status = _o_.status;
/*   80 */     this.flags = _o_.flags;
/*   81 */     this.userid = _o_.userid;
/*   82 */     this.cost = _o_.cost;
/*   83 */     this.cost_bind = _o_.cost_bind;
/*   84 */     this.present = _o_.present;
/*   85 */     this.present_bind = _o_.present_bind;
/*   86 */     this.create_time = _o_.create_time;
/*   87 */     this.confirm_success_time = _o_.confirm_success_time;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   92 */     this.status = _o_.status;
/*   93 */     this.flags = _o_.flags;
/*   94 */     this.userid = _o_.userid;
/*   95 */     this.cost = _o_.cost;
/*   96 */     this.cost_bind = _o_.cost_bind;
/*   97 */     this.present = _o_.present;
/*   98 */     this.present_bind = _o_.present_bind;
/*   99 */     this.create_time = _o_.create_time;
/*  100 */     this.confirm_success_time = _o_.confirm_success_time;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*  106 */     _xdb_verify_unsafe_();
/*  107 */     _os_.marshal(this.status);
/*  108 */     _os_.marshal(this.flags);
/*  109 */     _os_.marshal(this.userid, "UTF-16LE");
/*  110 */     _os_.marshal(this.cost);
/*  111 */     _os_.marshal(this.cost_bind);
/*  112 */     _os_.marshal(this.present);
/*  113 */     _os_.marshal(this.present_bind);
/*  114 */     _os_.marshal(this.create_time);
/*  115 */     _os_.marshal(this.confirm_success_time);
/*  116 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  122 */     _xdb_verify_unsafe_();
/*  123 */     this.status = _os_.unmarshal_int();
/*  124 */     this.flags = _os_.unmarshal_int();
/*  125 */     this.userid = _os_.unmarshal_String("UTF-16LE");
/*  126 */     this.cost = _os_.unmarshal_int();
/*  127 */     this.cost_bind = _os_.unmarshal_int();
/*  128 */     this.present = _os_.unmarshal_int();
/*  129 */     this.present_bind = _os_.unmarshal_int();
/*  130 */     this.create_time = _os_.unmarshal_long();
/*  131 */     this.confirm_success_time = _os_.unmarshal_long();
/*  132 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  138 */     _xdb_verify_unsafe_();
/*  139 */     int _size_ = 0;
/*  140 */     _size_ += CodedOutputStream.computeInt32Size(1, this.status);
/*  141 */     _size_ += CodedOutputStream.computeInt32Size(2, this.flags);
/*      */     try
/*      */     {
/*  144 */       _size_ += CodedOutputStream.computeBytesSize(3, ByteString.copyFrom(this.userid, "UTF-16LE"));
/*      */     }
/*      */     catch (java.io.UnsupportedEncodingException e)
/*      */     {
/*  148 */       throw new RuntimeException("UTF-16LE not supported?", e);
/*      */     }
/*  150 */     _size_ += CodedOutputStream.computeInt32Size(4, this.cost);
/*  151 */     _size_ += CodedOutputStream.computeInt32Size(5, this.cost_bind);
/*  152 */     _size_ += CodedOutputStream.computeInt32Size(6, this.present);
/*  153 */     _size_ += CodedOutputStream.computeInt32Size(7, this.present_bind);
/*  154 */     _size_ += CodedOutputStream.computeInt64Size(8, this.create_time);
/*  155 */     _size_ += CodedOutputStream.computeInt64Size(9, this.confirm_success_time);
/*  156 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  162 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  165 */       _output_.writeInt32(1, this.status);
/*  166 */       _output_.writeInt32(2, this.flags);
/*  167 */       _output_.writeBytes(3, ByteString.copyFrom(this.userid, "UTF-16LE"));
/*  168 */       _output_.writeInt32(4, this.cost);
/*  169 */       _output_.writeInt32(5, this.cost_bind);
/*  170 */       _output_.writeInt32(6, this.present);
/*  171 */       _output_.writeInt32(7, this.present_bind);
/*  172 */       _output_.writeInt64(8, this.create_time);
/*  173 */       _output_.writeInt64(9, this.confirm_success_time);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  177 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  179 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  185 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  188 */       boolean done = false;
/*  189 */       while (!done)
/*      */       {
/*  191 */         int tag = _input_.readTag();
/*  192 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  196 */           done = true;
/*  197 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  201 */           this.status = _input_.readInt32();
/*  202 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  206 */           this.flags = _input_.readInt32();
/*  207 */           break;
/*      */         
/*      */ 
/*      */         case 26: 
/*  211 */           this.userid = _input_.readBytes().toString("UTF-16LE");
/*  212 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  216 */           this.cost = _input_.readInt32();
/*  217 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  221 */           this.cost_bind = _input_.readInt32();
/*  222 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  226 */           this.present = _input_.readInt32();
/*  227 */           break;
/*      */         
/*      */ 
/*      */         case 56: 
/*  231 */           this.present_bind = _input_.readInt32();
/*  232 */           break;
/*      */         
/*      */ 
/*      */         case 64: 
/*  236 */           this.create_time = _input_.readInt64();
/*  237 */           break;
/*      */         
/*      */ 
/*      */         case 72: 
/*  241 */           this.confirm_success_time = _input_.readInt64();
/*  242 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  246 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  248 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  257 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  261 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  263 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.CheckOrderInfo copy()
/*      */   {
/*  269 */     _xdb_verify_unsafe_();
/*  270 */     return new CheckOrderInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.CheckOrderInfo toData()
/*      */   {
/*  276 */     _xdb_verify_unsafe_();
/*  277 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.CheckOrderInfo toBean()
/*      */   {
/*  282 */     _xdb_verify_unsafe_();
/*  283 */     return new CheckOrderInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.CheckOrderInfo toDataIf()
/*      */   {
/*  289 */     _xdb_verify_unsafe_();
/*  290 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.CheckOrderInfo toBeanIf()
/*      */   {
/*  295 */     _xdb_verify_unsafe_();
/*  296 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public Bean toConst()
/*      */   {
/*  302 */     _xdb_verify_unsafe_();
/*  303 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getStatus()
/*      */   {
/*  310 */     _xdb_verify_unsafe_();
/*  311 */     return this.status;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getFlags()
/*      */   {
/*  318 */     _xdb_verify_unsafe_();
/*  319 */     return this.flags;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public String getUserid()
/*      */   {
/*  326 */     _xdb_verify_unsafe_();
/*  327 */     return this.userid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Octets getUseridOctets()
/*      */   {
/*  334 */     _xdb_verify_unsafe_();
/*  335 */     return Octets.wrap(getUserid(), "UTF-16LE");
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getCost()
/*      */   {
/*  342 */     _xdb_verify_unsafe_();
/*  343 */     return this.cost;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getCost_bind()
/*      */   {
/*  350 */     _xdb_verify_unsafe_();
/*  351 */     return this.cost_bind;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getPresent()
/*      */   {
/*  358 */     _xdb_verify_unsafe_();
/*  359 */     return this.present;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getPresent_bind()
/*      */   {
/*  366 */     _xdb_verify_unsafe_();
/*  367 */     return this.present_bind;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getCreate_time()
/*      */   {
/*  374 */     _xdb_verify_unsafe_();
/*  375 */     return this.create_time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getConfirm_success_time()
/*      */   {
/*  382 */     _xdb_verify_unsafe_();
/*  383 */     return this.confirm_success_time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setStatus(int _v_)
/*      */   {
/*  390 */     _xdb_verify_unsafe_();
/*  391 */     Logs.logIf(new LogKey(this, "status")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  395 */         new LogInt(this, CheckOrderInfo.this.status)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  399 */             CheckOrderInfo.this.status = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  403 */     });
/*  404 */     this.status = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setFlags(int _v_)
/*      */   {
/*  411 */     _xdb_verify_unsafe_();
/*  412 */     Logs.logIf(new LogKey(this, "flags")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  416 */         new LogInt(this, CheckOrderInfo.this.flags)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  420 */             CheckOrderInfo.this.flags = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  424 */     });
/*  425 */     this.flags = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setUserid(String _v_)
/*      */   {
/*  432 */     _xdb_verify_unsafe_();
/*  433 */     if (null == _v_)
/*  434 */       throw new NullPointerException();
/*  435 */     Logs.logIf(new LogKey(this, "userid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  439 */         new xdb.logs.LogString(this, CheckOrderInfo.this.userid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  443 */             CheckOrderInfo.this.userid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  447 */     });
/*  448 */     this.userid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setUseridOctets(Octets _v_)
/*      */   {
/*  455 */     _xdb_verify_unsafe_();
/*  456 */     setUserid(_v_.getString("UTF-16LE"));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCost(int _v_)
/*      */   {
/*  463 */     _xdb_verify_unsafe_();
/*  464 */     Logs.logIf(new LogKey(this, "cost")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  468 */         new LogInt(this, CheckOrderInfo.this.cost)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  472 */             CheckOrderInfo.this.cost = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  476 */     });
/*  477 */     this.cost = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCost_bind(int _v_)
/*      */   {
/*  484 */     _xdb_verify_unsafe_();
/*  485 */     Logs.logIf(new LogKey(this, "cost_bind")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  489 */         new LogInt(this, CheckOrderInfo.this.cost_bind)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  493 */             CheckOrderInfo.this.cost_bind = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  497 */     });
/*  498 */     this.cost_bind = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setPresent(int _v_)
/*      */   {
/*  505 */     _xdb_verify_unsafe_();
/*  506 */     Logs.logIf(new LogKey(this, "present")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  510 */         new LogInt(this, CheckOrderInfo.this.present)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  514 */             CheckOrderInfo.this.present = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  518 */     });
/*  519 */     this.present = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setPresent_bind(int _v_)
/*      */   {
/*  526 */     _xdb_verify_unsafe_();
/*  527 */     Logs.logIf(new LogKey(this, "present_bind")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  531 */         new LogInt(this, CheckOrderInfo.this.present_bind)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  535 */             CheckOrderInfo.this.present_bind = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  539 */     });
/*  540 */     this.present_bind = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCreate_time(long _v_)
/*      */   {
/*  547 */     _xdb_verify_unsafe_();
/*  548 */     Logs.logIf(new LogKey(this, "create_time")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  552 */         new LogLong(this, CheckOrderInfo.this.create_time)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  556 */             CheckOrderInfo.this.create_time = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  560 */     });
/*  561 */     this.create_time = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setConfirm_success_time(long _v_)
/*      */   {
/*  568 */     _xdb_verify_unsafe_();
/*  569 */     Logs.logIf(new LogKey(this, "confirm_success_time")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  573 */         new LogLong(this, CheckOrderInfo.this.confirm_success_time)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  577 */             CheckOrderInfo.this.confirm_success_time = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  581 */     });
/*  582 */     this.confirm_success_time = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  588 */     _xdb_verify_unsafe_();
/*  589 */     CheckOrderInfo _o_ = null;
/*  590 */     if ((_o1_ instanceof CheckOrderInfo)) { _o_ = (CheckOrderInfo)_o1_;
/*  591 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  592 */       return false;
/*  593 */     if (this.status != _o_.status) return false;
/*  594 */     if (this.flags != _o_.flags) return false;
/*  595 */     if (!this.userid.equals(_o_.userid)) return false;
/*  596 */     if (this.cost != _o_.cost) return false;
/*  597 */     if (this.cost_bind != _o_.cost_bind) return false;
/*  598 */     if (this.present != _o_.present) return false;
/*  599 */     if (this.present_bind != _o_.present_bind) return false;
/*  600 */     if (this.create_time != _o_.create_time) return false;
/*  601 */     if (this.confirm_success_time != _o_.confirm_success_time) return false;
/*  602 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  608 */     _xdb_verify_unsafe_();
/*  609 */     int _h_ = 0;
/*  610 */     _h_ += this.status;
/*  611 */     _h_ += this.flags;
/*  612 */     _h_ += this.userid.hashCode();
/*  613 */     _h_ += this.cost;
/*  614 */     _h_ += this.cost_bind;
/*  615 */     _h_ += this.present;
/*  616 */     _h_ += this.present_bind;
/*  617 */     _h_ = (int)(_h_ + this.create_time);
/*  618 */     _h_ = (int)(_h_ + this.confirm_success_time);
/*  619 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  625 */     _xdb_verify_unsafe_();
/*  626 */     StringBuilder _sb_ = new StringBuilder();
/*  627 */     _sb_.append("(");
/*  628 */     _sb_.append(this.status);
/*  629 */     _sb_.append(",");
/*  630 */     _sb_.append(this.flags);
/*  631 */     _sb_.append(",");
/*  632 */     _sb_.append("'").append(this.userid).append("'");
/*  633 */     _sb_.append(",");
/*  634 */     _sb_.append(this.cost);
/*  635 */     _sb_.append(",");
/*  636 */     _sb_.append(this.cost_bind);
/*  637 */     _sb_.append(",");
/*  638 */     _sb_.append(this.present);
/*  639 */     _sb_.append(",");
/*  640 */     _sb_.append(this.present_bind);
/*  641 */     _sb_.append(",");
/*  642 */     _sb_.append(this.create_time);
/*  643 */     _sb_.append(",");
/*  644 */     _sb_.append(this.confirm_success_time);
/*  645 */     _sb_.append(")");
/*  646 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  652 */     ListenableBean lb = new ListenableBean();
/*  653 */     lb.add(new ListenableChanged().setVarName("status"));
/*  654 */     lb.add(new ListenableChanged().setVarName("flags"));
/*  655 */     lb.add(new ListenableChanged().setVarName("userid"));
/*  656 */     lb.add(new ListenableChanged().setVarName("cost"));
/*  657 */     lb.add(new ListenableChanged().setVarName("cost_bind"));
/*  658 */     lb.add(new ListenableChanged().setVarName("present"));
/*  659 */     lb.add(new ListenableChanged().setVarName("present_bind"));
/*  660 */     lb.add(new ListenableChanged().setVarName("create_time"));
/*  661 */     lb.add(new ListenableChanged().setVarName("confirm_success_time"));
/*  662 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.CheckOrderInfo {
/*      */     private Const() {}
/*      */     
/*      */     CheckOrderInfo nThis() {
/*  669 */       return CheckOrderInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  675 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CheckOrderInfo copy()
/*      */     {
/*  681 */       return CheckOrderInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CheckOrderInfo toData()
/*      */     {
/*  687 */       return CheckOrderInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.CheckOrderInfo toBean()
/*      */     {
/*  692 */       return CheckOrderInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CheckOrderInfo toDataIf()
/*      */     {
/*  698 */       return CheckOrderInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.CheckOrderInfo toBeanIf()
/*      */     {
/*  703 */       return CheckOrderInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getStatus()
/*      */     {
/*  710 */       CheckOrderInfo.this._xdb_verify_unsafe_();
/*  711 */       return CheckOrderInfo.this.status;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getFlags()
/*      */     {
/*  718 */       CheckOrderInfo.this._xdb_verify_unsafe_();
/*  719 */       return CheckOrderInfo.this.flags;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getUserid()
/*      */     {
/*  726 */       CheckOrderInfo.this._xdb_verify_unsafe_();
/*  727 */       return CheckOrderInfo.this.userid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getUseridOctets()
/*      */     {
/*  734 */       CheckOrderInfo.this._xdb_verify_unsafe_();
/*  735 */       return CheckOrderInfo.this.getUseridOctets();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCost()
/*      */     {
/*  742 */       CheckOrderInfo.this._xdb_verify_unsafe_();
/*  743 */       return CheckOrderInfo.this.cost;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCost_bind()
/*      */     {
/*  750 */       CheckOrderInfo.this._xdb_verify_unsafe_();
/*  751 */       return CheckOrderInfo.this.cost_bind;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPresent()
/*      */     {
/*  758 */       CheckOrderInfo.this._xdb_verify_unsafe_();
/*  759 */       return CheckOrderInfo.this.present;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPresent_bind()
/*      */     {
/*  766 */       CheckOrderInfo.this._xdb_verify_unsafe_();
/*  767 */       return CheckOrderInfo.this.present_bind;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getCreate_time()
/*      */     {
/*  774 */       CheckOrderInfo.this._xdb_verify_unsafe_();
/*  775 */       return CheckOrderInfo.this.create_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getConfirm_success_time()
/*      */     {
/*  782 */       CheckOrderInfo.this._xdb_verify_unsafe_();
/*  783 */       return CheckOrderInfo.this.confirm_success_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setStatus(int _v_)
/*      */     {
/*  790 */       CheckOrderInfo.this._xdb_verify_unsafe_();
/*  791 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFlags(int _v_)
/*      */     {
/*  798 */       CheckOrderInfo.this._xdb_verify_unsafe_();
/*  799 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setUserid(String _v_)
/*      */     {
/*  806 */       CheckOrderInfo.this._xdb_verify_unsafe_();
/*  807 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setUseridOctets(Octets _v_)
/*      */     {
/*  814 */       CheckOrderInfo.this._xdb_verify_unsafe_();
/*  815 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCost(int _v_)
/*      */     {
/*  822 */       CheckOrderInfo.this._xdb_verify_unsafe_();
/*  823 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCost_bind(int _v_)
/*      */     {
/*  830 */       CheckOrderInfo.this._xdb_verify_unsafe_();
/*  831 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPresent(int _v_)
/*      */     {
/*  838 */       CheckOrderInfo.this._xdb_verify_unsafe_();
/*  839 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPresent_bind(int _v_)
/*      */     {
/*  846 */       CheckOrderInfo.this._xdb_verify_unsafe_();
/*  847 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCreate_time(long _v_)
/*      */     {
/*  854 */       CheckOrderInfo.this._xdb_verify_unsafe_();
/*  855 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setConfirm_success_time(long _v_)
/*      */     {
/*  862 */       CheckOrderInfo.this._xdb_verify_unsafe_();
/*  863 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean toConst()
/*      */     {
/*  869 */       CheckOrderInfo.this._xdb_verify_unsafe_();
/*  870 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  876 */       CheckOrderInfo.this._xdb_verify_unsafe_();
/*  877 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  883 */       return CheckOrderInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  889 */       return CheckOrderInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  895 */       CheckOrderInfo.this._xdb_verify_unsafe_();
/*  896 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  902 */       return CheckOrderInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  908 */       return CheckOrderInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  914 */       CheckOrderInfo.this._xdb_verify_unsafe_();
/*  915 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean xdbParent()
/*      */     {
/*  921 */       return CheckOrderInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  927 */       return CheckOrderInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  933 */       return CheckOrderInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  939 */       return CheckOrderInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  945 */       return CheckOrderInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  951 */       return CheckOrderInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  957 */       return CheckOrderInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.CheckOrderInfo
/*      */   {
/*      */     private int status;
/*      */     
/*      */     private int flags;
/*      */     
/*      */     private String userid;
/*      */     
/*      */     private int cost;
/*      */     
/*      */     private int cost_bind;
/*      */     
/*      */     private int present;
/*      */     
/*      */     private int present_bind;
/*      */     
/*      */     private long create_time;
/*      */     
/*      */     private long confirm_success_time;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  985 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  990 */       this.userid = "";
/*  991 */       this.cost = 0;
/*  992 */       this.cost_bind = 0;
/*  993 */       this.present = 0;
/*  994 */       this.present_bind = 0;
/*  995 */       this.create_time = 0L;
/*  996 */       this.confirm_success_time = 0L;
/*      */     }
/*      */     
/*      */     Data(xbean.CheckOrderInfo _o1_)
/*      */     {
/* 1001 */       if ((_o1_ instanceof CheckOrderInfo)) { assign((CheckOrderInfo)_o1_);
/* 1002 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 1003 */       } else if ((_o1_ instanceof CheckOrderInfo.Const)) assign(((CheckOrderInfo.Const)_o1_).nThis()); else {
/* 1004 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(CheckOrderInfo _o_) {
/* 1009 */       this.status = _o_.status;
/* 1010 */       this.flags = _o_.flags;
/* 1011 */       this.userid = _o_.userid;
/* 1012 */       this.cost = _o_.cost;
/* 1013 */       this.cost_bind = _o_.cost_bind;
/* 1014 */       this.present = _o_.present;
/* 1015 */       this.present_bind = _o_.present_bind;
/* 1016 */       this.create_time = _o_.create_time;
/* 1017 */       this.confirm_success_time = _o_.confirm_success_time;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/* 1022 */       this.status = _o_.status;
/* 1023 */       this.flags = _o_.flags;
/* 1024 */       this.userid = _o_.userid;
/* 1025 */       this.cost = _o_.cost;
/* 1026 */       this.cost_bind = _o_.cost_bind;
/* 1027 */       this.present = _o_.present;
/* 1028 */       this.present_bind = _o_.present_bind;
/* 1029 */       this.create_time = _o_.create_time;
/* 1030 */       this.confirm_success_time = _o_.confirm_success_time;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 1036 */       _os_.marshal(this.status);
/* 1037 */       _os_.marshal(this.flags);
/* 1038 */       _os_.marshal(this.userid, "UTF-16LE");
/* 1039 */       _os_.marshal(this.cost);
/* 1040 */       _os_.marshal(this.cost_bind);
/* 1041 */       _os_.marshal(this.present);
/* 1042 */       _os_.marshal(this.present_bind);
/* 1043 */       _os_.marshal(this.create_time);
/* 1044 */       _os_.marshal(this.confirm_success_time);
/* 1045 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/* 1051 */       this.status = _os_.unmarshal_int();
/* 1052 */       this.flags = _os_.unmarshal_int();
/* 1053 */       this.userid = _os_.unmarshal_String("UTF-16LE");
/* 1054 */       this.cost = _os_.unmarshal_int();
/* 1055 */       this.cost_bind = _os_.unmarshal_int();
/* 1056 */       this.present = _os_.unmarshal_int();
/* 1057 */       this.present_bind = _os_.unmarshal_int();
/* 1058 */       this.create_time = _os_.unmarshal_long();
/* 1059 */       this.confirm_success_time = _os_.unmarshal_long();
/* 1060 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/* 1066 */       int _size_ = 0;
/* 1067 */       _size_ += CodedOutputStream.computeInt32Size(1, this.status);
/* 1068 */       _size_ += CodedOutputStream.computeInt32Size(2, this.flags);
/*      */       try
/*      */       {
/* 1071 */         _size_ += CodedOutputStream.computeBytesSize(3, ByteString.copyFrom(this.userid, "UTF-16LE"));
/*      */       }
/*      */       catch (java.io.UnsupportedEncodingException e)
/*      */       {
/* 1075 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*      */       }
/* 1077 */       _size_ += CodedOutputStream.computeInt32Size(4, this.cost);
/* 1078 */       _size_ += CodedOutputStream.computeInt32Size(5, this.cost_bind);
/* 1079 */       _size_ += CodedOutputStream.computeInt32Size(6, this.present);
/* 1080 */       _size_ += CodedOutputStream.computeInt32Size(7, this.present_bind);
/* 1081 */       _size_ += CodedOutputStream.computeInt64Size(8, this.create_time);
/* 1082 */       _size_ += CodedOutputStream.computeInt64Size(9, this.confirm_success_time);
/* 1083 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1091 */         _output_.writeInt32(1, this.status);
/* 1092 */         _output_.writeInt32(2, this.flags);
/* 1093 */         _output_.writeBytes(3, ByteString.copyFrom(this.userid, "UTF-16LE"));
/* 1094 */         _output_.writeInt32(4, this.cost);
/* 1095 */         _output_.writeInt32(5, this.cost_bind);
/* 1096 */         _output_.writeInt32(6, this.present);
/* 1097 */         _output_.writeInt32(7, this.present_bind);
/* 1098 */         _output_.writeInt64(8, this.create_time);
/* 1099 */         _output_.writeInt64(9, this.confirm_success_time);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1103 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1105 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1113 */         boolean done = false;
/* 1114 */         while (!done)
/*      */         {
/* 1116 */           int tag = _input_.readTag();
/* 1117 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/* 1121 */             done = true;
/* 1122 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/* 1126 */             this.status = _input_.readInt32();
/* 1127 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/* 1131 */             this.flags = _input_.readInt32();
/* 1132 */             break;
/*      */           
/*      */ 
/*      */           case 26: 
/* 1136 */             this.userid = _input_.readBytes().toString("UTF-16LE");
/* 1137 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/* 1141 */             this.cost = _input_.readInt32();
/* 1142 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/* 1146 */             this.cost_bind = _input_.readInt32();
/* 1147 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/* 1151 */             this.present = _input_.readInt32();
/* 1152 */             break;
/*      */           
/*      */ 
/*      */           case 56: 
/* 1156 */             this.present_bind = _input_.readInt32();
/* 1157 */             break;
/*      */           
/*      */ 
/*      */           case 64: 
/* 1161 */             this.create_time = _input_.readInt64();
/* 1162 */             break;
/*      */           
/*      */ 
/*      */           case 72: 
/* 1166 */             this.confirm_success_time = _input_.readInt64();
/* 1167 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1171 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1173 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1182 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1186 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1188 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CheckOrderInfo copy()
/*      */     {
/* 1194 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CheckOrderInfo toData()
/*      */     {
/* 1200 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.CheckOrderInfo toBean()
/*      */     {
/* 1205 */       return new CheckOrderInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CheckOrderInfo toDataIf()
/*      */     {
/* 1211 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.CheckOrderInfo toBeanIf()
/*      */     {
/* 1216 */       return new CheckOrderInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1222 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean xdbParent() {
/* 1226 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1230 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1234 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean toConst() {
/* 1238 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1242 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1246 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getStatus()
/*      */     {
/* 1253 */       return this.status;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getFlags()
/*      */     {
/* 1260 */       return this.flags;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getUserid()
/*      */     {
/* 1267 */       return this.userid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getUseridOctets()
/*      */     {
/* 1274 */       return Octets.wrap(getUserid(), "UTF-16LE");
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCost()
/*      */     {
/* 1281 */       return this.cost;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCost_bind()
/*      */     {
/* 1288 */       return this.cost_bind;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPresent()
/*      */     {
/* 1295 */       return this.present;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPresent_bind()
/*      */     {
/* 1302 */       return this.present_bind;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getCreate_time()
/*      */     {
/* 1309 */       return this.create_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getConfirm_success_time()
/*      */     {
/* 1316 */       return this.confirm_success_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setStatus(int _v_)
/*      */     {
/* 1323 */       this.status = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFlags(int _v_)
/*      */     {
/* 1330 */       this.flags = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setUserid(String _v_)
/*      */     {
/* 1337 */       if (null == _v_)
/* 1338 */         throw new NullPointerException();
/* 1339 */       this.userid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setUseridOctets(Octets _v_)
/*      */     {
/* 1346 */       setUserid(_v_.getString("UTF-16LE"));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCost(int _v_)
/*      */     {
/* 1353 */       this.cost = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCost_bind(int _v_)
/*      */     {
/* 1360 */       this.cost_bind = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPresent(int _v_)
/*      */     {
/* 1367 */       this.present = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPresent_bind(int _v_)
/*      */     {
/* 1374 */       this.present_bind = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCreate_time(long _v_)
/*      */     {
/* 1381 */       this.create_time = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setConfirm_success_time(long _v_)
/*      */     {
/* 1388 */       this.confirm_success_time = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1394 */       if (!(_o1_ instanceof Data)) return false;
/* 1395 */       Data _o_ = (Data)_o1_;
/* 1396 */       if (this.status != _o_.status) return false;
/* 1397 */       if (this.flags != _o_.flags) return false;
/* 1398 */       if (!this.userid.equals(_o_.userid)) return false;
/* 1399 */       if (this.cost != _o_.cost) return false;
/* 1400 */       if (this.cost_bind != _o_.cost_bind) return false;
/* 1401 */       if (this.present != _o_.present) return false;
/* 1402 */       if (this.present_bind != _o_.present_bind) return false;
/* 1403 */       if (this.create_time != _o_.create_time) return false;
/* 1404 */       if (this.confirm_success_time != _o_.confirm_success_time) return false;
/* 1405 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1411 */       int _h_ = 0;
/* 1412 */       _h_ += this.status;
/* 1413 */       _h_ += this.flags;
/* 1414 */       _h_ += this.userid.hashCode();
/* 1415 */       _h_ += this.cost;
/* 1416 */       _h_ += this.cost_bind;
/* 1417 */       _h_ += this.present;
/* 1418 */       _h_ += this.present_bind;
/* 1419 */       _h_ = (int)(_h_ + this.create_time);
/* 1420 */       _h_ = (int)(_h_ + this.confirm_success_time);
/* 1421 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1427 */       StringBuilder _sb_ = new StringBuilder();
/* 1428 */       _sb_.append("(");
/* 1429 */       _sb_.append(this.status);
/* 1430 */       _sb_.append(",");
/* 1431 */       _sb_.append(this.flags);
/* 1432 */       _sb_.append(",");
/* 1433 */       _sb_.append("'").append(this.userid).append("'");
/* 1434 */       _sb_.append(",");
/* 1435 */       _sb_.append(this.cost);
/* 1436 */       _sb_.append(",");
/* 1437 */       _sb_.append(this.cost_bind);
/* 1438 */       _sb_.append(",");
/* 1439 */       _sb_.append(this.present);
/* 1440 */       _sb_.append(",");
/* 1441 */       _sb_.append(this.present_bind);
/* 1442 */       _sb_.append(",");
/* 1443 */       _sb_.append(this.create_time);
/* 1444 */       _sb_.append(",");
/* 1445 */       _sb_.append(this.confirm_success_time);
/* 1446 */       _sb_.append(")");
/* 1447 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\CheckOrderInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */