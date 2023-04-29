/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import com.goldhuman.Common.Octets;
/*      */ import java.io.IOException;
/*      */ import java.io.UnsupportedEncodingException;
/*      */ import ppbio.ByteString;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.Log;
/*      */ import xdb.LogKey;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ 
/*      */ public final class RecallUserInfo extends XBean implements xbean.RecallUserInfo
/*      */ {
/*      */   private String user_id;
/*      */   private long recall_time;
/*      */   private long recall_role_id;
/*      */   private String recall_openid;
/*      */   private long start_time;
/*      */   private int be_recall_num;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   28 */     this.user_id = "";
/*   29 */     this.recall_time = 0L;
/*   30 */     this.recall_role_id = 0L;
/*   31 */     this.recall_openid = "";
/*   32 */     this.start_time = 0L;
/*   33 */     this.be_recall_num = 0;
/*      */   }
/*      */   
/*      */   RecallUserInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   38 */     super(_xp_, _vn_);
/*   39 */     this.user_id = "";
/*   40 */     this.recall_openid = "";
/*      */   }
/*      */   
/*      */   public RecallUserInfo()
/*      */   {
/*   45 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public RecallUserInfo(RecallUserInfo _o_)
/*      */   {
/*   50 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   RecallUserInfo(xbean.RecallUserInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   55 */     super(_xp_, _vn_);
/*   56 */     if ((_o1_ instanceof RecallUserInfo)) { assign((RecallUserInfo)_o1_);
/*   57 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   58 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   59 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(RecallUserInfo _o_) {
/*   64 */     _o_._xdb_verify_unsafe_();
/*   65 */     this.user_id = _o_.user_id;
/*   66 */     this.recall_time = _o_.recall_time;
/*   67 */     this.recall_role_id = _o_.recall_role_id;
/*   68 */     this.recall_openid = _o_.recall_openid;
/*   69 */     this.start_time = _o_.start_time;
/*   70 */     this.be_recall_num = _o_.be_recall_num;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   75 */     this.user_id = _o_.user_id;
/*   76 */     this.recall_time = _o_.recall_time;
/*   77 */     this.recall_role_id = _o_.recall_role_id;
/*   78 */     this.recall_openid = _o_.recall_openid;
/*   79 */     this.start_time = _o_.start_time;
/*   80 */     this.be_recall_num = _o_.be_recall_num;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   86 */     _xdb_verify_unsafe_();
/*   87 */     _os_.marshal(this.user_id, "UTF-16LE");
/*   88 */     _os_.marshal(this.recall_time);
/*   89 */     _os_.marshal(this.recall_role_id);
/*   90 */     _os_.marshal(this.recall_openid, "UTF-16LE");
/*   91 */     _os_.marshal(this.start_time);
/*   92 */     _os_.marshal(this.be_recall_num);
/*   93 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*   99 */     _xdb_verify_unsafe_();
/*  100 */     this.user_id = _os_.unmarshal_String("UTF-16LE");
/*  101 */     this.recall_time = _os_.unmarshal_long();
/*  102 */     this.recall_role_id = _os_.unmarshal_long();
/*  103 */     this.recall_openid = _os_.unmarshal_String("UTF-16LE");
/*  104 */     this.start_time = _os_.unmarshal_long();
/*  105 */     this.be_recall_num = _os_.unmarshal_int();
/*  106 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  112 */     _xdb_verify_unsafe_();
/*  113 */     int _size_ = 0;
/*      */     try
/*      */     {
/*  116 */       _size_ += CodedOutputStream.computeBytesSize(1, ByteString.copyFrom(this.user_id, "UTF-16LE"));
/*      */     }
/*      */     catch (UnsupportedEncodingException e)
/*      */     {
/*  120 */       throw new RuntimeException("UTF-16LE not supported?", e);
/*      */     }
/*  122 */     _size_ += CodedOutputStream.computeInt64Size(2, this.recall_time);
/*  123 */     _size_ += CodedOutputStream.computeInt64Size(3, this.recall_role_id);
/*      */     try
/*      */     {
/*  126 */       _size_ += CodedOutputStream.computeBytesSize(4, ByteString.copyFrom(this.recall_openid, "UTF-16LE"));
/*      */     }
/*      */     catch (UnsupportedEncodingException e)
/*      */     {
/*  130 */       throw new RuntimeException("UTF-16LE not supported?", e);
/*      */     }
/*  132 */     _size_ += CodedOutputStream.computeInt64Size(5, this.start_time);
/*  133 */     _size_ += CodedOutputStream.computeInt32Size(6, this.be_recall_num);
/*  134 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  140 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  143 */       _output_.writeBytes(1, ByteString.copyFrom(this.user_id, "UTF-16LE"));
/*  144 */       _output_.writeInt64(2, this.recall_time);
/*  145 */       _output_.writeInt64(3, this.recall_role_id);
/*  146 */       _output_.writeBytes(4, ByteString.copyFrom(this.recall_openid, "UTF-16LE"));
/*  147 */       _output_.writeInt64(5, this.start_time);
/*  148 */       _output_.writeInt32(6, this.be_recall_num);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  152 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  154 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  160 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  163 */       boolean done = false;
/*  164 */       while (!done)
/*      */       {
/*  166 */         int tag = _input_.readTag();
/*  167 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  171 */           done = true;
/*  172 */           break;
/*      */         
/*      */ 
/*      */         case 10: 
/*  176 */           this.user_id = _input_.readBytes().toString("UTF-16LE");
/*  177 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  181 */           this.recall_time = _input_.readInt64();
/*  182 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  186 */           this.recall_role_id = _input_.readInt64();
/*  187 */           break;
/*      */         
/*      */ 
/*      */         case 34: 
/*  191 */           this.recall_openid = _input_.readBytes().toString("UTF-16LE");
/*  192 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  196 */           this.start_time = _input_.readInt64();
/*  197 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  201 */           this.be_recall_num = _input_.readInt32();
/*  202 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  206 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  208 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  217 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  221 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  223 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.RecallUserInfo copy()
/*      */   {
/*  229 */     _xdb_verify_unsafe_();
/*  230 */     return new RecallUserInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.RecallUserInfo toData()
/*      */   {
/*  236 */     _xdb_verify_unsafe_();
/*  237 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.RecallUserInfo toBean()
/*      */   {
/*  242 */     _xdb_verify_unsafe_();
/*  243 */     return new RecallUserInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.RecallUserInfo toDataIf()
/*      */   {
/*  249 */     _xdb_verify_unsafe_();
/*  250 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.RecallUserInfo toBeanIf()
/*      */   {
/*  255 */     _xdb_verify_unsafe_();
/*  256 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  262 */     _xdb_verify_unsafe_();
/*  263 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public String getUser_id()
/*      */   {
/*  270 */     _xdb_verify_unsafe_();
/*  271 */     return this.user_id;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Octets getUser_idOctets()
/*      */   {
/*  278 */     _xdb_verify_unsafe_();
/*  279 */     return Octets.wrap(getUser_id(), "UTF-16LE");
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getRecall_time()
/*      */   {
/*  286 */     _xdb_verify_unsafe_();
/*  287 */     return this.recall_time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getRecall_role_id()
/*      */   {
/*  294 */     _xdb_verify_unsafe_();
/*  295 */     return this.recall_role_id;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public String getRecall_openid()
/*      */   {
/*  302 */     _xdb_verify_unsafe_();
/*  303 */     return this.recall_openid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Octets getRecall_openidOctets()
/*      */   {
/*  310 */     _xdb_verify_unsafe_();
/*  311 */     return Octets.wrap(getRecall_openid(), "UTF-16LE");
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getStart_time()
/*      */   {
/*  318 */     _xdb_verify_unsafe_();
/*  319 */     return this.start_time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getBe_recall_num()
/*      */   {
/*  326 */     _xdb_verify_unsafe_();
/*  327 */     return this.be_recall_num;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setUser_id(String _v_)
/*      */   {
/*  334 */     _xdb_verify_unsafe_();
/*  335 */     if (null == _v_)
/*  336 */       throw new NullPointerException();
/*  337 */     xdb.Logs.logIf(new LogKey(this, "user_id")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  341 */         new xdb.logs.LogString(this, RecallUserInfo.this.user_id)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  345 */             RecallUserInfo.this.user_id = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  349 */     });
/*  350 */     this.user_id = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setUser_idOctets(Octets _v_)
/*      */   {
/*  357 */     _xdb_verify_unsafe_();
/*  358 */     setUser_id(_v_.getString("UTF-16LE"));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setRecall_time(long _v_)
/*      */   {
/*  365 */     _xdb_verify_unsafe_();
/*  366 */     xdb.Logs.logIf(new LogKey(this, "recall_time")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  370 */         new xdb.logs.LogLong(this, RecallUserInfo.this.recall_time)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  374 */             RecallUserInfo.this.recall_time = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  378 */     });
/*  379 */     this.recall_time = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setRecall_role_id(long _v_)
/*      */   {
/*  386 */     _xdb_verify_unsafe_();
/*  387 */     xdb.Logs.logIf(new LogKey(this, "recall_role_id")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  391 */         new xdb.logs.LogLong(this, RecallUserInfo.this.recall_role_id)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  395 */             RecallUserInfo.this.recall_role_id = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  399 */     });
/*  400 */     this.recall_role_id = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setRecall_openid(String _v_)
/*      */   {
/*  407 */     _xdb_verify_unsafe_();
/*  408 */     if (null == _v_)
/*  409 */       throw new NullPointerException();
/*  410 */     xdb.Logs.logIf(new LogKey(this, "recall_openid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  414 */         new xdb.logs.LogString(this, RecallUserInfo.this.recall_openid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  418 */             RecallUserInfo.this.recall_openid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  422 */     });
/*  423 */     this.recall_openid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setRecall_openidOctets(Octets _v_)
/*      */   {
/*  430 */     _xdb_verify_unsafe_();
/*  431 */     setRecall_openid(_v_.getString("UTF-16LE"));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setStart_time(long _v_)
/*      */   {
/*  438 */     _xdb_verify_unsafe_();
/*  439 */     xdb.Logs.logIf(new LogKey(this, "start_time")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  443 */         new xdb.logs.LogLong(this, RecallUserInfo.this.start_time)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  447 */             RecallUserInfo.this.start_time = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  451 */     });
/*  452 */     this.start_time = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setBe_recall_num(int _v_)
/*      */   {
/*  459 */     _xdb_verify_unsafe_();
/*  460 */     xdb.Logs.logIf(new LogKey(this, "be_recall_num")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  464 */         new xdb.logs.LogInt(this, RecallUserInfo.this.be_recall_num)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  468 */             RecallUserInfo.this.be_recall_num = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  472 */     });
/*  473 */     this.be_recall_num = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  479 */     _xdb_verify_unsafe_();
/*  480 */     RecallUserInfo _o_ = null;
/*  481 */     if ((_o1_ instanceof RecallUserInfo)) { _o_ = (RecallUserInfo)_o1_;
/*  482 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  483 */       return false;
/*  484 */     if (!this.user_id.equals(_o_.user_id)) return false;
/*  485 */     if (this.recall_time != _o_.recall_time) return false;
/*  486 */     if (this.recall_role_id != _o_.recall_role_id) return false;
/*  487 */     if (!this.recall_openid.equals(_o_.recall_openid)) return false;
/*  488 */     if (this.start_time != _o_.start_time) return false;
/*  489 */     if (this.be_recall_num != _o_.be_recall_num) return false;
/*  490 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  496 */     _xdb_verify_unsafe_();
/*  497 */     int _h_ = 0;
/*  498 */     _h_ += this.user_id.hashCode();
/*  499 */     _h_ = (int)(_h_ + this.recall_time);
/*  500 */     _h_ = (int)(_h_ + this.recall_role_id);
/*  501 */     _h_ += this.recall_openid.hashCode();
/*  502 */     _h_ = (int)(_h_ + this.start_time);
/*  503 */     _h_ += this.be_recall_num;
/*  504 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  510 */     _xdb_verify_unsafe_();
/*  511 */     StringBuilder _sb_ = new StringBuilder();
/*  512 */     _sb_.append("(");
/*  513 */     _sb_.append("'").append(this.user_id).append("'");
/*  514 */     _sb_.append(",");
/*  515 */     _sb_.append(this.recall_time);
/*  516 */     _sb_.append(",");
/*  517 */     _sb_.append(this.recall_role_id);
/*  518 */     _sb_.append(",");
/*  519 */     _sb_.append("'").append(this.recall_openid).append("'");
/*  520 */     _sb_.append(",");
/*  521 */     _sb_.append(this.start_time);
/*  522 */     _sb_.append(",");
/*  523 */     _sb_.append(this.be_recall_num);
/*  524 */     _sb_.append(")");
/*  525 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  531 */     ListenableBean lb = new ListenableBean();
/*  532 */     lb.add(new ListenableChanged().setVarName("user_id"));
/*  533 */     lb.add(new ListenableChanged().setVarName("recall_time"));
/*  534 */     lb.add(new ListenableChanged().setVarName("recall_role_id"));
/*  535 */     lb.add(new ListenableChanged().setVarName("recall_openid"));
/*  536 */     lb.add(new ListenableChanged().setVarName("start_time"));
/*  537 */     lb.add(new ListenableChanged().setVarName("be_recall_num"));
/*  538 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.RecallUserInfo {
/*      */     private Const() {}
/*      */     
/*      */     RecallUserInfo nThis() {
/*  545 */       return RecallUserInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  551 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RecallUserInfo copy()
/*      */     {
/*  557 */       return RecallUserInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RecallUserInfo toData()
/*      */     {
/*  563 */       return RecallUserInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.RecallUserInfo toBean()
/*      */     {
/*  568 */       return RecallUserInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RecallUserInfo toDataIf()
/*      */     {
/*  574 */       return RecallUserInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.RecallUserInfo toBeanIf()
/*      */     {
/*  579 */       return RecallUserInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getUser_id()
/*      */     {
/*  586 */       RecallUserInfo.this._xdb_verify_unsafe_();
/*  587 */       return RecallUserInfo.this.user_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getUser_idOctets()
/*      */     {
/*  594 */       RecallUserInfo.this._xdb_verify_unsafe_();
/*  595 */       return RecallUserInfo.this.getUser_idOctets();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getRecall_time()
/*      */     {
/*  602 */       RecallUserInfo.this._xdb_verify_unsafe_();
/*  603 */       return RecallUserInfo.this.recall_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getRecall_role_id()
/*      */     {
/*  610 */       RecallUserInfo.this._xdb_verify_unsafe_();
/*  611 */       return RecallUserInfo.this.recall_role_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getRecall_openid()
/*      */     {
/*  618 */       RecallUserInfo.this._xdb_verify_unsafe_();
/*  619 */       return RecallUserInfo.this.recall_openid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getRecall_openidOctets()
/*      */     {
/*  626 */       RecallUserInfo.this._xdb_verify_unsafe_();
/*  627 */       return RecallUserInfo.this.getRecall_openidOctets();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getStart_time()
/*      */     {
/*  634 */       RecallUserInfo.this._xdb_verify_unsafe_();
/*  635 */       return RecallUserInfo.this.start_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getBe_recall_num()
/*      */     {
/*  642 */       RecallUserInfo.this._xdb_verify_unsafe_();
/*  643 */       return RecallUserInfo.this.be_recall_num;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setUser_id(String _v_)
/*      */     {
/*  650 */       RecallUserInfo.this._xdb_verify_unsafe_();
/*  651 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setUser_idOctets(Octets _v_)
/*      */     {
/*  658 */       RecallUserInfo.this._xdb_verify_unsafe_();
/*  659 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRecall_time(long _v_)
/*      */     {
/*  666 */       RecallUserInfo.this._xdb_verify_unsafe_();
/*  667 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRecall_role_id(long _v_)
/*      */     {
/*  674 */       RecallUserInfo.this._xdb_verify_unsafe_();
/*  675 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRecall_openid(String _v_)
/*      */     {
/*  682 */       RecallUserInfo.this._xdb_verify_unsafe_();
/*  683 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRecall_openidOctets(Octets _v_)
/*      */     {
/*  690 */       RecallUserInfo.this._xdb_verify_unsafe_();
/*  691 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setStart_time(long _v_)
/*      */     {
/*  698 */       RecallUserInfo.this._xdb_verify_unsafe_();
/*  699 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBe_recall_num(int _v_)
/*      */     {
/*  706 */       RecallUserInfo.this._xdb_verify_unsafe_();
/*  707 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  713 */       RecallUserInfo.this._xdb_verify_unsafe_();
/*  714 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  720 */       RecallUserInfo.this._xdb_verify_unsafe_();
/*  721 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  727 */       return RecallUserInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  733 */       return RecallUserInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  739 */       RecallUserInfo.this._xdb_verify_unsafe_();
/*  740 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  746 */       return RecallUserInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  752 */       return RecallUserInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  758 */       RecallUserInfo.this._xdb_verify_unsafe_();
/*  759 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  765 */       return RecallUserInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  771 */       return RecallUserInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  777 */       return RecallUserInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  783 */       return RecallUserInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  789 */       return RecallUserInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  795 */       return RecallUserInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  801 */       return RecallUserInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.RecallUserInfo
/*      */   {
/*      */     private String user_id;
/*      */     
/*      */     private long recall_time;
/*      */     
/*      */     private long recall_role_id;
/*      */     
/*      */     private String recall_openid;
/*      */     
/*      */     private long start_time;
/*      */     
/*      */     private int be_recall_num;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  823 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  828 */       this.user_id = "";
/*  829 */       this.recall_openid = "";
/*      */     }
/*      */     
/*      */     Data(xbean.RecallUserInfo _o1_)
/*      */     {
/*  834 */       if ((_o1_ instanceof RecallUserInfo)) { assign((RecallUserInfo)_o1_);
/*  835 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  836 */       } else if ((_o1_ instanceof RecallUserInfo.Const)) assign(((RecallUserInfo.Const)_o1_).nThis()); else {
/*  837 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(RecallUserInfo _o_) {
/*  842 */       this.user_id = _o_.user_id;
/*  843 */       this.recall_time = _o_.recall_time;
/*  844 */       this.recall_role_id = _o_.recall_role_id;
/*  845 */       this.recall_openid = _o_.recall_openid;
/*  846 */       this.start_time = _o_.start_time;
/*  847 */       this.be_recall_num = _o_.be_recall_num;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  852 */       this.user_id = _o_.user_id;
/*  853 */       this.recall_time = _o_.recall_time;
/*  854 */       this.recall_role_id = _o_.recall_role_id;
/*  855 */       this.recall_openid = _o_.recall_openid;
/*  856 */       this.start_time = _o_.start_time;
/*  857 */       this.be_recall_num = _o_.be_recall_num;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  863 */       _os_.marshal(this.user_id, "UTF-16LE");
/*  864 */       _os_.marshal(this.recall_time);
/*  865 */       _os_.marshal(this.recall_role_id);
/*  866 */       _os_.marshal(this.recall_openid, "UTF-16LE");
/*  867 */       _os_.marshal(this.start_time);
/*  868 */       _os_.marshal(this.be_recall_num);
/*  869 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  875 */       this.user_id = _os_.unmarshal_String("UTF-16LE");
/*  876 */       this.recall_time = _os_.unmarshal_long();
/*  877 */       this.recall_role_id = _os_.unmarshal_long();
/*  878 */       this.recall_openid = _os_.unmarshal_String("UTF-16LE");
/*  879 */       this.start_time = _os_.unmarshal_long();
/*  880 */       this.be_recall_num = _os_.unmarshal_int();
/*  881 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  887 */       int _size_ = 0;
/*      */       try
/*      */       {
/*  890 */         _size_ += CodedOutputStream.computeBytesSize(1, ByteString.copyFrom(this.user_id, "UTF-16LE"));
/*      */       }
/*      */       catch (UnsupportedEncodingException e)
/*      */       {
/*  894 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*      */       }
/*  896 */       _size_ += CodedOutputStream.computeInt64Size(2, this.recall_time);
/*  897 */       _size_ += CodedOutputStream.computeInt64Size(3, this.recall_role_id);
/*      */       try
/*      */       {
/*  900 */         _size_ += CodedOutputStream.computeBytesSize(4, ByteString.copyFrom(this.recall_openid, "UTF-16LE"));
/*      */       }
/*      */       catch (UnsupportedEncodingException e)
/*      */       {
/*  904 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*      */       }
/*  906 */       _size_ += CodedOutputStream.computeInt64Size(5, this.start_time);
/*  907 */       _size_ += CodedOutputStream.computeInt32Size(6, this.be_recall_num);
/*  908 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  916 */         _output_.writeBytes(1, ByteString.copyFrom(this.user_id, "UTF-16LE"));
/*  917 */         _output_.writeInt64(2, this.recall_time);
/*  918 */         _output_.writeInt64(3, this.recall_role_id);
/*  919 */         _output_.writeBytes(4, ByteString.copyFrom(this.recall_openid, "UTF-16LE"));
/*  920 */         _output_.writeInt64(5, this.start_time);
/*  921 */         _output_.writeInt32(6, this.be_recall_num);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  925 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  927 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  935 */         boolean done = false;
/*  936 */         while (!done)
/*      */         {
/*  938 */           int tag = _input_.readTag();
/*  939 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  943 */             done = true;
/*  944 */             break;
/*      */           
/*      */ 
/*      */           case 10: 
/*  948 */             this.user_id = _input_.readBytes().toString("UTF-16LE");
/*  949 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  953 */             this.recall_time = _input_.readInt64();
/*  954 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/*  958 */             this.recall_role_id = _input_.readInt64();
/*  959 */             break;
/*      */           
/*      */ 
/*      */           case 34: 
/*  963 */             this.recall_openid = _input_.readBytes().toString("UTF-16LE");
/*  964 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/*  968 */             this.start_time = _input_.readInt64();
/*  969 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/*  973 */             this.be_recall_num = _input_.readInt32();
/*  974 */             break;
/*      */           
/*      */ 
/*      */           default: 
/*  978 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/*  980 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/*  989 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  993 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  995 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RecallUserInfo copy()
/*      */     {
/* 1001 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RecallUserInfo toData()
/*      */     {
/* 1007 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.RecallUserInfo toBean()
/*      */     {
/* 1012 */       return new RecallUserInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RecallUserInfo toDataIf()
/*      */     {
/* 1018 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.RecallUserInfo toBeanIf()
/*      */     {
/* 1023 */       return new RecallUserInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1029 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/* 1033 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1037 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1041 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/* 1045 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1049 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1053 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getUser_id()
/*      */     {
/* 1060 */       return this.user_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getUser_idOctets()
/*      */     {
/* 1067 */       return Octets.wrap(getUser_id(), "UTF-16LE");
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getRecall_time()
/*      */     {
/* 1074 */       return this.recall_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getRecall_role_id()
/*      */     {
/* 1081 */       return this.recall_role_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getRecall_openid()
/*      */     {
/* 1088 */       return this.recall_openid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getRecall_openidOctets()
/*      */     {
/* 1095 */       return Octets.wrap(getRecall_openid(), "UTF-16LE");
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getStart_time()
/*      */     {
/* 1102 */       return this.start_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getBe_recall_num()
/*      */     {
/* 1109 */       return this.be_recall_num;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setUser_id(String _v_)
/*      */     {
/* 1116 */       if (null == _v_)
/* 1117 */         throw new NullPointerException();
/* 1118 */       this.user_id = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setUser_idOctets(Octets _v_)
/*      */     {
/* 1125 */       setUser_id(_v_.getString("UTF-16LE"));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRecall_time(long _v_)
/*      */     {
/* 1132 */       this.recall_time = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRecall_role_id(long _v_)
/*      */     {
/* 1139 */       this.recall_role_id = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRecall_openid(String _v_)
/*      */     {
/* 1146 */       if (null == _v_)
/* 1147 */         throw new NullPointerException();
/* 1148 */       this.recall_openid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRecall_openidOctets(Octets _v_)
/*      */     {
/* 1155 */       setRecall_openid(_v_.getString("UTF-16LE"));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setStart_time(long _v_)
/*      */     {
/* 1162 */       this.start_time = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBe_recall_num(int _v_)
/*      */     {
/* 1169 */       this.be_recall_num = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1175 */       if (!(_o1_ instanceof Data)) return false;
/* 1176 */       Data _o_ = (Data)_o1_;
/* 1177 */       if (!this.user_id.equals(_o_.user_id)) return false;
/* 1178 */       if (this.recall_time != _o_.recall_time) return false;
/* 1179 */       if (this.recall_role_id != _o_.recall_role_id) return false;
/* 1180 */       if (!this.recall_openid.equals(_o_.recall_openid)) return false;
/* 1181 */       if (this.start_time != _o_.start_time) return false;
/* 1182 */       if (this.be_recall_num != _o_.be_recall_num) return false;
/* 1183 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1189 */       int _h_ = 0;
/* 1190 */       _h_ += this.user_id.hashCode();
/* 1191 */       _h_ = (int)(_h_ + this.recall_time);
/* 1192 */       _h_ = (int)(_h_ + this.recall_role_id);
/* 1193 */       _h_ += this.recall_openid.hashCode();
/* 1194 */       _h_ = (int)(_h_ + this.start_time);
/* 1195 */       _h_ += this.be_recall_num;
/* 1196 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1202 */       StringBuilder _sb_ = new StringBuilder();
/* 1203 */       _sb_.append("(");
/* 1204 */       _sb_.append("'").append(this.user_id).append("'");
/* 1205 */       _sb_.append(",");
/* 1206 */       _sb_.append(this.recall_time);
/* 1207 */       _sb_.append(",");
/* 1208 */       _sb_.append(this.recall_role_id);
/* 1209 */       _sb_.append(",");
/* 1210 */       _sb_.append("'").append(this.recall_openid).append("'");
/* 1211 */       _sb_.append(",");
/* 1212 */       _sb_.append(this.start_time);
/* 1213 */       _sb_.append(",");
/* 1214 */       _sb_.append(this.be_recall_num);
/* 1215 */       _sb_.append(")");
/* 1216 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\RecallUserInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */