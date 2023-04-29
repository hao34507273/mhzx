/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import com.goldhuman.Common.Octets;
/*      */ import java.io.IOException;
/*      */ import java.util.ArrayList;
/*      */ import java.util.List;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.LogKey;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.LogLong;
/*      */ 
/*      */ public final class SwornNewMember extends XBean implements xbean.SwornNewMember
/*      */ {
/*      */   private long roleid;
/*      */   private long newmemberid;
/*      */   private String newmembertitle;
/*      */   private long verifytime;
/*      */   private ArrayList<Long> verifyids;
/*      */   private ArrayList<Long> voteids;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   28 */     this.roleid = 0L;
/*   29 */     this.newmemberid = 0L;
/*   30 */     this.newmembertitle = "";
/*   31 */     this.verifytime = 0L;
/*   32 */     this.verifyids.clear();
/*   33 */     this.voteids.clear();
/*      */   }
/*      */   
/*      */   SwornNewMember(int __, XBean _xp_, String _vn_)
/*      */   {
/*   38 */     super(_xp_, _vn_);
/*   39 */     this.newmembertitle = "";
/*   40 */     this.verifytime = 0L;
/*   41 */     this.verifyids = new ArrayList();
/*   42 */     this.voteids = new ArrayList();
/*      */   }
/*      */   
/*      */   public SwornNewMember()
/*      */   {
/*   47 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public SwornNewMember(SwornNewMember _o_)
/*      */   {
/*   52 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   SwornNewMember(xbean.SwornNewMember _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   57 */     super(_xp_, _vn_);
/*   58 */     if ((_o1_ instanceof SwornNewMember)) { assign((SwornNewMember)_o1_);
/*   59 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   60 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   61 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(SwornNewMember _o_) {
/*   66 */     _o_._xdb_verify_unsafe_();
/*   67 */     this.roleid = _o_.roleid;
/*   68 */     this.newmemberid = _o_.newmemberid;
/*   69 */     this.newmembertitle = _o_.newmembertitle;
/*   70 */     this.verifytime = _o_.verifytime;
/*   71 */     this.verifyids = new ArrayList();
/*   72 */     this.verifyids.addAll(_o_.verifyids);
/*   73 */     this.voteids = new ArrayList();
/*   74 */     this.voteids.addAll(_o_.voteids);
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   79 */     this.roleid = _o_.roleid;
/*   80 */     this.newmemberid = _o_.newmemberid;
/*   81 */     this.newmembertitle = _o_.newmembertitle;
/*   82 */     this.verifytime = _o_.verifytime;
/*   83 */     this.verifyids = new ArrayList();
/*   84 */     this.verifyids.addAll(_o_.verifyids);
/*   85 */     this.voteids = new ArrayList();
/*   86 */     this.voteids.addAll(_o_.voteids);
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   92 */     _xdb_verify_unsafe_();
/*   93 */     _os_.marshal(this.roleid);
/*   94 */     _os_.marshal(this.newmemberid);
/*   95 */     _os_.marshal(this.newmembertitle, "UTF-16LE");
/*   96 */     _os_.marshal(this.verifytime);
/*   97 */     _os_.compact_uint32(this.verifyids.size());
/*   98 */     for (Long _v_ : this.verifyids)
/*      */     {
/*  100 */       _os_.marshal(_v_.longValue());
/*      */     }
/*  102 */     _os_.compact_uint32(this.voteids.size());
/*  103 */     for (Long _v_ : this.voteids)
/*      */     {
/*  105 */       _os_.marshal(_v_.longValue());
/*      */     }
/*  107 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  113 */     _xdb_verify_unsafe_();
/*  114 */     this.roleid = _os_.unmarshal_long();
/*  115 */     this.newmemberid = _os_.unmarshal_long();
/*  116 */     this.newmembertitle = _os_.unmarshal_String("UTF-16LE");
/*  117 */     this.verifytime = _os_.unmarshal_long();
/*  118 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  120 */       long _v_ = 0L;
/*  121 */       _v_ = _os_.unmarshal_long();
/*  122 */       this.verifyids.add(Long.valueOf(_v_));
/*      */     }
/*  124 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  126 */       long _v_ = 0L;
/*  127 */       _v_ = _os_.unmarshal_long();
/*  128 */       this.voteids.add(Long.valueOf(_v_));
/*      */     }
/*  130 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  136 */     _xdb_verify_unsafe_();
/*  137 */     int _size_ = 0;
/*  138 */     _size_ += CodedOutputStream.computeInt64Size(1, this.roleid);
/*  139 */     _size_ += CodedOutputStream.computeInt64Size(2, this.newmemberid);
/*      */     try
/*      */     {
/*  142 */       _size_ += CodedOutputStream.computeBytesSize(3, ppbio.ByteString.copyFrom(this.newmembertitle, "UTF-16LE"));
/*      */     }
/*      */     catch (java.io.UnsupportedEncodingException e)
/*      */     {
/*  146 */       throw new RuntimeException("UTF-16LE not supported?", e);
/*      */     }
/*  148 */     _size_ += CodedOutputStream.computeInt64Size(4, this.verifytime);
/*  149 */     for (Long _v_ : this.verifyids)
/*      */     {
/*  151 */       _size_ += CodedOutputStream.computeInt64Size(5, _v_.longValue());
/*      */     }
/*  153 */     for (Long _v_ : this.voteids)
/*      */     {
/*  155 */       _size_ += CodedOutputStream.computeInt64Size(6, _v_.longValue());
/*      */     }
/*  157 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  163 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  166 */       _output_.writeInt64(1, this.roleid);
/*  167 */       _output_.writeInt64(2, this.newmemberid);
/*  168 */       _output_.writeBytes(3, ppbio.ByteString.copyFrom(this.newmembertitle, "UTF-16LE"));
/*  169 */       _output_.writeInt64(4, this.verifytime);
/*  170 */       for (Long _v_ : this.verifyids)
/*      */       {
/*  172 */         _output_.writeInt64(5, _v_.longValue());
/*      */       }
/*  174 */       for (Long _v_ : this.voteids)
/*      */       {
/*  176 */         _output_.writeInt64(6, _v_.longValue());
/*      */       }
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  181 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  183 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  189 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  192 */       boolean done = false;
/*  193 */       while (!done)
/*      */       {
/*  195 */         int tag = _input_.readTag();
/*  196 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  200 */           done = true;
/*  201 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  205 */           this.roleid = _input_.readInt64();
/*  206 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  210 */           this.newmemberid = _input_.readInt64();
/*  211 */           break;
/*      */         
/*      */ 
/*      */         case 26: 
/*  215 */           this.newmembertitle = _input_.readBytes().toString("UTF-16LE");
/*  216 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  220 */           this.verifytime = _input_.readInt64();
/*  221 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  225 */           long _v_ = 0L;
/*  226 */           _v_ = _input_.readInt64();
/*  227 */           this.verifyids.add(Long.valueOf(_v_));
/*  228 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  232 */           long _v_ = 0L;
/*  233 */           _v_ = _input_.readInt64();
/*  234 */           this.voteids.add(Long.valueOf(_v_));
/*  235 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  239 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  241 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  250 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  254 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  256 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.SwornNewMember copy()
/*      */   {
/*  262 */     _xdb_verify_unsafe_();
/*  263 */     return new SwornNewMember(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.SwornNewMember toData()
/*      */   {
/*  269 */     _xdb_verify_unsafe_();
/*  270 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.SwornNewMember toBean()
/*      */   {
/*  275 */     _xdb_verify_unsafe_();
/*  276 */     return new SwornNewMember(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.SwornNewMember toDataIf()
/*      */   {
/*  282 */     _xdb_verify_unsafe_();
/*  283 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.SwornNewMember toBeanIf()
/*      */   {
/*  288 */     _xdb_verify_unsafe_();
/*  289 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  295 */     _xdb_verify_unsafe_();
/*  296 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getRoleid()
/*      */   {
/*  303 */     _xdb_verify_unsafe_();
/*  304 */     return this.roleid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getNewmemberid()
/*      */   {
/*  311 */     _xdb_verify_unsafe_();
/*  312 */     return this.newmemberid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public String getNewmembertitle()
/*      */   {
/*  319 */     _xdb_verify_unsafe_();
/*  320 */     return this.newmembertitle;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Octets getNewmembertitleOctets()
/*      */   {
/*  327 */     _xdb_verify_unsafe_();
/*  328 */     return Octets.wrap(getNewmembertitle(), "UTF-16LE");
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getVerifytime()
/*      */   {
/*  335 */     _xdb_verify_unsafe_();
/*  336 */     return this.verifytime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<Long> getVerifyids()
/*      */   {
/*  343 */     _xdb_verify_unsafe_();
/*  344 */     return xdb.Logs.logList(new LogKey(this, "verifyids"), this.verifyids);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<Long> getVerifyidsAsData()
/*      */   {
/*  350 */     _xdb_verify_unsafe_();
/*      */     
/*  352 */     SwornNewMember _o_ = this;
/*  353 */     List<Long> verifyids = new ArrayList();
/*  354 */     verifyids.addAll(_o_.verifyids);
/*  355 */     return verifyids;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<Long> getVoteids()
/*      */   {
/*  362 */     _xdb_verify_unsafe_();
/*  363 */     return xdb.Logs.logList(new LogKey(this, "voteids"), this.voteids);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<Long> getVoteidsAsData()
/*      */   {
/*  369 */     _xdb_verify_unsafe_();
/*      */     
/*  371 */     SwornNewMember _o_ = this;
/*  372 */     List<Long> voteids = new ArrayList();
/*  373 */     voteids.addAll(_o_.voteids);
/*  374 */     return voteids;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setRoleid(long _v_)
/*      */   {
/*  381 */     _xdb_verify_unsafe_();
/*  382 */     xdb.Logs.logIf(new LogKey(this, "roleid")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  386 */         new LogLong(this, SwornNewMember.this.roleid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  390 */             SwornNewMember.this.roleid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  394 */     });
/*  395 */     this.roleid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setNewmemberid(long _v_)
/*      */   {
/*  402 */     _xdb_verify_unsafe_();
/*  403 */     xdb.Logs.logIf(new LogKey(this, "newmemberid")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  407 */         new LogLong(this, SwornNewMember.this.newmemberid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  411 */             SwornNewMember.this.newmemberid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  415 */     });
/*  416 */     this.newmemberid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setNewmembertitle(String _v_)
/*      */   {
/*  423 */     _xdb_verify_unsafe_();
/*  424 */     if (null == _v_)
/*  425 */       throw new NullPointerException();
/*  426 */     xdb.Logs.logIf(new LogKey(this, "newmembertitle")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  430 */         new xdb.logs.LogString(this, SwornNewMember.this.newmembertitle)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  434 */             SwornNewMember.this.newmembertitle = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  438 */     });
/*  439 */     this.newmembertitle = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setNewmembertitleOctets(Octets _v_)
/*      */   {
/*  446 */     _xdb_verify_unsafe_();
/*  447 */     setNewmembertitle(_v_.getString("UTF-16LE"));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setVerifytime(long _v_)
/*      */   {
/*  454 */     _xdb_verify_unsafe_();
/*  455 */     xdb.Logs.logIf(new LogKey(this, "verifytime")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  459 */         new LogLong(this, SwornNewMember.this.verifytime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  463 */             SwornNewMember.this.verifytime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  467 */     });
/*  468 */     this.verifytime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  474 */     _xdb_verify_unsafe_();
/*  475 */     SwornNewMember _o_ = null;
/*  476 */     if ((_o1_ instanceof SwornNewMember)) { _o_ = (SwornNewMember)_o1_;
/*  477 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  478 */       return false;
/*  479 */     if (this.roleid != _o_.roleid) return false;
/*  480 */     if (this.newmemberid != _o_.newmemberid) return false;
/*  481 */     if (!this.newmembertitle.equals(_o_.newmembertitle)) return false;
/*  482 */     if (this.verifytime != _o_.verifytime) return false;
/*  483 */     if (!this.verifyids.equals(_o_.verifyids)) return false;
/*  484 */     if (!this.voteids.equals(_o_.voteids)) return false;
/*  485 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  491 */     _xdb_verify_unsafe_();
/*  492 */     int _h_ = 0;
/*  493 */     _h_ = (int)(_h_ + this.roleid);
/*  494 */     _h_ = (int)(_h_ + this.newmemberid);
/*  495 */     _h_ += this.newmembertitle.hashCode();
/*  496 */     _h_ = (int)(_h_ + this.verifytime);
/*  497 */     _h_ += this.verifyids.hashCode();
/*  498 */     _h_ += this.voteids.hashCode();
/*  499 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  505 */     _xdb_verify_unsafe_();
/*  506 */     StringBuilder _sb_ = new StringBuilder();
/*  507 */     _sb_.append("(");
/*  508 */     _sb_.append(this.roleid);
/*  509 */     _sb_.append(",");
/*  510 */     _sb_.append(this.newmemberid);
/*  511 */     _sb_.append(",");
/*  512 */     _sb_.append("'").append(this.newmembertitle).append("'");
/*  513 */     _sb_.append(",");
/*  514 */     _sb_.append(this.verifytime);
/*  515 */     _sb_.append(",");
/*  516 */     _sb_.append(this.verifyids);
/*  517 */     _sb_.append(",");
/*  518 */     _sb_.append(this.voteids);
/*  519 */     _sb_.append(")");
/*  520 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  526 */     ListenableBean lb = new ListenableBean();
/*  527 */     lb.add(new ListenableChanged().setVarName("roleid"));
/*  528 */     lb.add(new ListenableChanged().setVarName("newmemberid"));
/*  529 */     lb.add(new ListenableChanged().setVarName("newmembertitle"));
/*  530 */     lb.add(new ListenableChanged().setVarName("verifytime"));
/*  531 */     lb.add(new ListenableChanged().setVarName("verifyids"));
/*  532 */     lb.add(new ListenableChanged().setVarName("voteids"));
/*  533 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.SwornNewMember {
/*      */     private Const() {}
/*      */     
/*      */     SwornNewMember nThis() {
/*  540 */       return SwornNewMember.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  546 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.SwornNewMember copy()
/*      */     {
/*  552 */       return SwornNewMember.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.SwornNewMember toData()
/*      */     {
/*  558 */       return SwornNewMember.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.SwornNewMember toBean()
/*      */     {
/*  563 */       return SwornNewMember.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.SwornNewMember toDataIf()
/*      */     {
/*  569 */       return SwornNewMember.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.SwornNewMember toBeanIf()
/*      */     {
/*  574 */       return SwornNewMember.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getRoleid()
/*      */     {
/*  581 */       SwornNewMember.this._xdb_verify_unsafe_();
/*  582 */       return SwornNewMember.this.roleid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getNewmemberid()
/*      */     {
/*  589 */       SwornNewMember.this._xdb_verify_unsafe_();
/*  590 */       return SwornNewMember.this.newmemberid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getNewmembertitle()
/*      */     {
/*  597 */       SwornNewMember.this._xdb_verify_unsafe_();
/*  598 */       return SwornNewMember.this.newmembertitle;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getNewmembertitleOctets()
/*      */     {
/*  605 */       SwornNewMember.this._xdb_verify_unsafe_();
/*  606 */       return SwornNewMember.this.getNewmembertitleOctets();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getVerifytime()
/*      */     {
/*  613 */       SwornNewMember.this._xdb_verify_unsafe_();
/*  614 */       return SwornNewMember.this.verifytime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getVerifyids()
/*      */     {
/*  621 */       SwornNewMember.this._xdb_verify_unsafe_();
/*  622 */       return xdb.Consts.constList(SwornNewMember.this.verifyids);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<Long> getVerifyidsAsData()
/*      */     {
/*  628 */       SwornNewMember.this._xdb_verify_unsafe_();
/*      */       
/*  630 */       SwornNewMember _o_ = SwornNewMember.this;
/*  631 */       List<Long> verifyids = new ArrayList();
/*  632 */       verifyids.addAll(_o_.verifyids);
/*  633 */       return verifyids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getVoteids()
/*      */     {
/*  640 */       SwornNewMember.this._xdb_verify_unsafe_();
/*  641 */       return xdb.Consts.constList(SwornNewMember.this.voteids);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<Long> getVoteidsAsData()
/*      */     {
/*  647 */       SwornNewMember.this._xdb_verify_unsafe_();
/*      */       
/*  649 */       SwornNewMember _o_ = SwornNewMember.this;
/*  650 */       List<Long> voteids = new ArrayList();
/*  651 */       voteids.addAll(_o_.voteids);
/*  652 */       return voteids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRoleid(long _v_)
/*      */     {
/*  659 */       SwornNewMember.this._xdb_verify_unsafe_();
/*  660 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setNewmemberid(long _v_)
/*      */     {
/*  667 */       SwornNewMember.this._xdb_verify_unsafe_();
/*  668 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setNewmembertitle(String _v_)
/*      */     {
/*  675 */       SwornNewMember.this._xdb_verify_unsafe_();
/*  676 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setNewmembertitleOctets(Octets _v_)
/*      */     {
/*  683 */       SwornNewMember.this._xdb_verify_unsafe_();
/*  684 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setVerifytime(long _v_)
/*      */     {
/*  691 */       SwornNewMember.this._xdb_verify_unsafe_();
/*  692 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  698 */       SwornNewMember.this._xdb_verify_unsafe_();
/*  699 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  705 */       SwornNewMember.this._xdb_verify_unsafe_();
/*  706 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  712 */       return SwornNewMember.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  718 */       return SwornNewMember.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  724 */       SwornNewMember.this._xdb_verify_unsafe_();
/*  725 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  731 */       return SwornNewMember.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  737 */       return SwornNewMember.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  743 */       SwornNewMember.this._xdb_verify_unsafe_();
/*  744 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  750 */       return SwornNewMember.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  756 */       return SwornNewMember.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  762 */       return SwornNewMember.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  768 */       return SwornNewMember.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  774 */       return SwornNewMember.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  780 */       return SwornNewMember.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  786 */       return SwornNewMember.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.SwornNewMember
/*      */   {
/*      */     private long roleid;
/*      */     
/*      */     private long newmemberid;
/*      */     
/*      */     private String newmembertitle;
/*      */     
/*      */     private long verifytime;
/*      */     
/*      */     private ArrayList<Long> verifyids;
/*      */     
/*      */     private ArrayList<Long> voteids;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  808 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  813 */       this.newmembertitle = "";
/*  814 */       this.verifytime = 0L;
/*  815 */       this.verifyids = new ArrayList();
/*  816 */       this.voteids = new ArrayList();
/*      */     }
/*      */     
/*      */     Data(xbean.SwornNewMember _o1_)
/*      */     {
/*  821 */       if ((_o1_ instanceof SwornNewMember)) { assign((SwornNewMember)_o1_);
/*  822 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  823 */       } else if ((_o1_ instanceof SwornNewMember.Const)) assign(((SwornNewMember.Const)_o1_).nThis()); else {
/*  824 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(SwornNewMember _o_) {
/*  829 */       this.roleid = _o_.roleid;
/*  830 */       this.newmemberid = _o_.newmemberid;
/*  831 */       this.newmembertitle = _o_.newmembertitle;
/*  832 */       this.verifytime = _o_.verifytime;
/*  833 */       this.verifyids = new ArrayList();
/*  834 */       this.verifyids.addAll(_o_.verifyids);
/*  835 */       this.voteids = new ArrayList();
/*  836 */       this.voteids.addAll(_o_.voteids);
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  841 */       this.roleid = _o_.roleid;
/*  842 */       this.newmemberid = _o_.newmemberid;
/*  843 */       this.newmembertitle = _o_.newmembertitle;
/*  844 */       this.verifytime = _o_.verifytime;
/*  845 */       this.verifyids = new ArrayList();
/*  846 */       this.verifyids.addAll(_o_.verifyids);
/*  847 */       this.voteids = new ArrayList();
/*  848 */       this.voteids.addAll(_o_.voteids);
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  854 */       _os_.marshal(this.roleid);
/*  855 */       _os_.marshal(this.newmemberid);
/*  856 */       _os_.marshal(this.newmembertitle, "UTF-16LE");
/*  857 */       _os_.marshal(this.verifytime);
/*  858 */       _os_.compact_uint32(this.verifyids.size());
/*  859 */       for (Long _v_ : this.verifyids)
/*      */       {
/*  861 */         _os_.marshal(_v_.longValue());
/*      */       }
/*  863 */       _os_.compact_uint32(this.voteids.size());
/*  864 */       for (Long _v_ : this.voteids)
/*      */       {
/*  866 */         _os_.marshal(_v_.longValue());
/*      */       }
/*  868 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  874 */       this.roleid = _os_.unmarshal_long();
/*  875 */       this.newmemberid = _os_.unmarshal_long();
/*  876 */       this.newmembertitle = _os_.unmarshal_String("UTF-16LE");
/*  877 */       this.verifytime = _os_.unmarshal_long();
/*  878 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  880 */         long _v_ = 0L;
/*  881 */         _v_ = _os_.unmarshal_long();
/*  882 */         this.verifyids.add(Long.valueOf(_v_));
/*      */       }
/*  884 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  886 */         long _v_ = 0L;
/*  887 */         _v_ = _os_.unmarshal_long();
/*  888 */         this.voteids.add(Long.valueOf(_v_));
/*      */       }
/*  890 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  896 */       int _size_ = 0;
/*  897 */       _size_ += CodedOutputStream.computeInt64Size(1, this.roleid);
/*  898 */       _size_ += CodedOutputStream.computeInt64Size(2, this.newmemberid);
/*      */       try
/*      */       {
/*  901 */         _size_ += CodedOutputStream.computeBytesSize(3, ppbio.ByteString.copyFrom(this.newmembertitle, "UTF-16LE"));
/*      */       }
/*      */       catch (java.io.UnsupportedEncodingException e)
/*      */       {
/*  905 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*      */       }
/*  907 */       _size_ += CodedOutputStream.computeInt64Size(4, this.verifytime);
/*  908 */       for (Long _v_ : this.verifyids)
/*      */       {
/*  910 */         _size_ += CodedOutputStream.computeInt64Size(5, _v_.longValue());
/*      */       }
/*  912 */       for (Long _v_ : this.voteids)
/*      */       {
/*  914 */         _size_ += CodedOutputStream.computeInt64Size(6, _v_.longValue());
/*      */       }
/*  916 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  924 */         _output_.writeInt64(1, this.roleid);
/*  925 */         _output_.writeInt64(2, this.newmemberid);
/*  926 */         _output_.writeBytes(3, ppbio.ByteString.copyFrom(this.newmembertitle, "UTF-16LE"));
/*  927 */         _output_.writeInt64(4, this.verifytime);
/*  928 */         for (Long _v_ : this.verifyids)
/*      */         {
/*  930 */           _output_.writeInt64(5, _v_.longValue());
/*      */         }
/*  932 */         for (Long _v_ : this.voteids)
/*      */         {
/*  934 */           _output_.writeInt64(6, _v_.longValue());
/*      */         }
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  939 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  941 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  949 */         boolean done = false;
/*  950 */         while (!done)
/*      */         {
/*  952 */           int tag = _input_.readTag();
/*  953 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  957 */             done = true;
/*  958 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  962 */             this.roleid = _input_.readInt64();
/*  963 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  967 */             this.newmemberid = _input_.readInt64();
/*  968 */             break;
/*      */           
/*      */ 
/*      */           case 26: 
/*  972 */             this.newmembertitle = _input_.readBytes().toString("UTF-16LE");
/*  973 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/*  977 */             this.verifytime = _input_.readInt64();
/*  978 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/*  982 */             long _v_ = 0L;
/*  983 */             _v_ = _input_.readInt64();
/*  984 */             this.verifyids.add(Long.valueOf(_v_));
/*  985 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/*  989 */             long _v_ = 0L;
/*  990 */             _v_ = _input_.readInt64();
/*  991 */             this.voteids.add(Long.valueOf(_v_));
/*  992 */             break;
/*      */           
/*      */ 
/*      */           default: 
/*  996 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/*  998 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1007 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1011 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1013 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.SwornNewMember copy()
/*      */     {
/* 1019 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.SwornNewMember toData()
/*      */     {
/* 1025 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.SwornNewMember toBean()
/*      */     {
/* 1030 */       return new SwornNewMember(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.SwornNewMember toDataIf()
/*      */     {
/* 1036 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.SwornNewMember toBeanIf()
/*      */     {
/* 1041 */       return new SwornNewMember(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1047 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/* 1051 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1055 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1059 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/* 1063 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1067 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1071 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getRoleid()
/*      */     {
/* 1078 */       return this.roleid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getNewmemberid()
/*      */     {
/* 1085 */       return this.newmemberid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getNewmembertitle()
/*      */     {
/* 1092 */       return this.newmembertitle;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getNewmembertitleOctets()
/*      */     {
/* 1099 */       return Octets.wrap(getNewmembertitle(), "UTF-16LE");
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getVerifytime()
/*      */     {
/* 1106 */       return this.verifytime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getVerifyids()
/*      */     {
/* 1113 */       return this.verifyids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getVerifyidsAsData()
/*      */     {
/* 1120 */       return this.verifyids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getVoteids()
/*      */     {
/* 1127 */       return this.voteids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getVoteidsAsData()
/*      */     {
/* 1134 */       return this.voteids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRoleid(long _v_)
/*      */     {
/* 1141 */       this.roleid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setNewmemberid(long _v_)
/*      */     {
/* 1148 */       this.newmemberid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setNewmembertitle(String _v_)
/*      */     {
/* 1155 */       if (null == _v_)
/* 1156 */         throw new NullPointerException();
/* 1157 */       this.newmembertitle = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setNewmembertitleOctets(Octets _v_)
/*      */     {
/* 1164 */       setNewmembertitle(_v_.getString("UTF-16LE"));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setVerifytime(long _v_)
/*      */     {
/* 1171 */       this.verifytime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1177 */       if (!(_o1_ instanceof Data)) return false;
/* 1178 */       Data _o_ = (Data)_o1_;
/* 1179 */       if (this.roleid != _o_.roleid) return false;
/* 1180 */       if (this.newmemberid != _o_.newmemberid) return false;
/* 1181 */       if (!this.newmembertitle.equals(_o_.newmembertitle)) return false;
/* 1182 */       if (this.verifytime != _o_.verifytime) return false;
/* 1183 */       if (!this.verifyids.equals(_o_.verifyids)) return false;
/* 1184 */       if (!this.voteids.equals(_o_.voteids)) return false;
/* 1185 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1191 */       int _h_ = 0;
/* 1192 */       _h_ = (int)(_h_ + this.roleid);
/* 1193 */       _h_ = (int)(_h_ + this.newmemberid);
/* 1194 */       _h_ += this.newmembertitle.hashCode();
/* 1195 */       _h_ = (int)(_h_ + this.verifytime);
/* 1196 */       _h_ += this.verifyids.hashCode();
/* 1197 */       _h_ += this.voteids.hashCode();
/* 1198 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1204 */       StringBuilder _sb_ = new StringBuilder();
/* 1205 */       _sb_.append("(");
/* 1206 */       _sb_.append(this.roleid);
/* 1207 */       _sb_.append(",");
/* 1208 */       _sb_.append(this.newmemberid);
/* 1209 */       _sb_.append(",");
/* 1210 */       _sb_.append("'").append(this.newmembertitle).append("'");
/* 1211 */       _sb_.append(",");
/* 1212 */       _sb_.append(this.verifytime);
/* 1213 */       _sb_.append(",");
/* 1214 */       _sb_.append(this.verifyids);
/* 1215 */       _sb_.append(",");
/* 1216 */       _sb_.append(this.voteids);
/* 1217 */       _sb_.append(")");
/* 1218 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\SwornNewMember.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */